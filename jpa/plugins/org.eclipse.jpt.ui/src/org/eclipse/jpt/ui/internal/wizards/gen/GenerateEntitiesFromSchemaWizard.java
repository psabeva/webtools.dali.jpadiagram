/*******************************************************************************
 * Copyright (c) 2007, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/

package org.eclipse.jpt.ui.internal.wizards.gen;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jpt.core.EntityGeneratorDatabaseAnnotationNameBuilder;
import org.eclipse.jpt.core.JpaPlatform;
import org.eclipse.jpt.core.JpaProject;
import org.eclipse.jpt.core.JptCorePlugin;
import org.eclipse.jpt.core.context.persistence.PersistenceXml;
import org.eclipse.jpt.core.internal.synch.SynchronizeClassesJob;
import org.eclipse.jpt.db.Column;
import org.eclipse.jpt.db.ConnectionProfile;
import org.eclipse.jpt.db.ForeignKey;
import org.eclipse.jpt.db.Schema;
import org.eclipse.jpt.db.Table;
import org.eclipse.jpt.gen.internal2.BaseEntityGenCustomizer;
import org.eclipse.jpt.gen.internal2.DatabaseAnnotationNameBuilder;
import org.eclipse.jpt.gen.internal2.ORMGenCustomizer;
import org.eclipse.jpt.gen.internal2.PackageGenerator2;
import org.eclipse.jpt.ui.JptUiPlugin;
import org.eclipse.jpt.ui.internal.JptUiIcons;
import org.eclipse.jpt.ui.internal.JptUiMessages;
import org.eclipse.jpt.utility.internal.CollectionTools;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

@SuppressWarnings("restriction")
public class GenerateEntitiesFromSchemaWizard extends Wizard 
	implements INewWizard  {	
	
	public static final String HELP_CONTEXT_ID = JptUiPlugin.PLUGIN_ID + ".GenerateEntitiesFromSchemaWizard"; //$NON-NLS-1$

	private JpaProject jpaProject;

	private IStructuredSelection selection;

	private ORMGenCustomizer customizer = null;	

	private boolean synchronizePersistenceXml;

	private PromptJPAProjectWizardPage projectPage;	

	private TablesSelectorWizardPage tablesSelectorPage;

	private TableAssociationsWizardPage tableAssociationsPage;
	
	private DefaultTableGenerationWizardPage defaultTableGenerationPage;
	
	private TablesAndColumnsCustomizationWizardPage tablesAndColumnsCustomizationPage;
	
	public GenerateEntitiesFromSchemaWizard() {
		this.setWindowTitle( JptUiEntityGenMessages.GenerateEntitiesWizard_generateEntities);
	}
	
	public GenerateEntitiesFromSchemaWizard( JpaProject jpaProject, IStructuredSelection selection) {
		super();
		this.jpaProject = jpaProject;
		this.selection = selection;
		this.setWindowTitle( JptUiEntityGenMessages.GenerateEntitiesWizard_generateEntities);
	}
	
	public Image getDefaultPageImage() {
		return JptUiPlugin.getImage( JptUiIcons.ENTITY_WIZ_BANNER ) ;
	}	
	
	public void addPages() {
		super.addPages();

		setForcePreviousAndNextButtons(true);
		
		//If this.jpaProject is not initialized because user didn't select a JPA project
		if( this.jpaProject == null ){
			projectPage = new PromptJPAProjectWizardPage( HELP_CONTEXT_ID );
			this.addPage(projectPage);
			return;
		}
		addMainPages();
	}

	private void addMainPages()
	{
		this.tablesSelectorPage = new TablesSelectorWizardPage( this.jpaProject );
		this.addPage(tablesSelectorPage);
		
		this.tableAssociationsPage = new TableAssociationsWizardPage( this.jpaProject  );
		this.addPage(tableAssociationsPage);

		this.defaultTableGenerationPage = new DefaultTableGenerationWizardPage( this.jpaProject);
		this.addPage(defaultTableGenerationPage);
		this.defaultTableGenerationPage.init(this.selection);
		
		this.tablesAndColumnsCustomizationPage = new TablesAndColumnsCustomizationWizardPage( this.jpaProject );
		this.addPage(tablesAndColumnsCustomizationPage);
		this.tablesAndColumnsCustomizationPage.init(selection);		
	}
	
	public ORMGenCustomizer getORMGenCustomizer(){
		return this.customizer;
	}

	/**
	 * Create the ORMGenCustomizer when user selects a new connection profile and schema 
	 * 
	 * JpaPlatform implementor can provide a custom ORMGenCustomizer specific to a platform
	 * with AdapterFactory through Eclipse org.eclipse.core.runtime.adapters extension point:
	 * <pre> 
	 *  
	 *<extension
     *    point="org.eclipse.core.runtime.adapters">
     * <factory
     *       adaptableType="org.eclipse.jpt.eclipselink.core.internal.EclipseLinkPlatform"
     *       class="oracle.eclipse.tools.orm.internal.EclipseLinkORMGenCustomizerAdapterFactory">
     *    <adapter
     *          type="oracle.eclipse.tools.orm.internal.ORMGenCustomizer">
     *    </adapter>
     * </factory>
     *</extension>
	 *</pre> 
	 * 
	 * @param schema 
	 */
	public ORMGenCustomizer createORMGenCustomizer(Schema schema){
		JpaPlatform jpaPlatform = this.jpaProject.getJpaPlatform();
		Object obj = AdapterManager.getDefault().getAdapter( jpaPlatform, ORMGenCustomizer.class );
		if( obj != null  ){
			customizer = (ORMGenCustomizer) obj ; 
			customizer.init(getCustomizationFile(), schema );  
		}else{
			customizer = new BaseEntityGenCustomizer( );
			customizer.init(getCustomizationFile(), schema );  
		}
		return customizer;
	} 
	
	protected String getCustomizationFileName() {
		ConnectionProfile profile = getProjectConnectionProfile();
		String connection = profile==null?"":profile.getName();
		String name = "org.eclipse.jpt.entitygen." + (connection==null?"":connection.replace(' ', '-'));  //$NON-NLS-1$
		Schema schema = getDefaultSchema();
		if ( schema!= null  ) {
			name += "." + schema.getName();//$NON-NLS-1$
		}
		return name.toLowerCase();
	}
	
	/**
	 * Returns the nodes state file. 
	 */
	private File getCustomizationFile() {
		String projectPath = jpaProject.getProject().getLocation().toPortableString();
		File genDir = new File(projectPath + "/.settings");//$NON-NLS-1$
        genDir.mkdirs();
		return new File(genDir, getCustomizationFileName());
	}

	public boolean performFinish() {
		if( this.jpaProject == null )
			return true;
		
		try {
			this.customizer.setDatabaseAnnotationNameBuilder( buildDatabaseAnnotationNameBuilder() );
			this.customizer.save();
		} catch (IOException e) {
			JptUiPlugin.log(e);
		}
		
		this.synchronizePersistenceXml = this.tablesSelectorPage.synchronizePersistenceXml();

		if( WarnOverwriteDialog.shouldShowDialog() ){
			if( !this.openConfirmDialog() )
				return false;
		}

		WorkspaceJob genEntitiesJob = new GenerateEntitiesJob( this.jpaProject,  getCustomizer() );
		
		WorkspaceJob synchClassesJob = null;
		if (synchronizePersistenceXml()) {
			// we currently only support *one* persistence.xml file per project
			PersistenceXml persistenceXml = jpaProject.getRootContextNode().getPersistenceXml();
			if (persistenceXml != null) {
				// TODO casting to IFile - just trying to get rid of all compiler errors for now
				synchClassesJob = new SynchronizeClassesJob((IFile) persistenceXml.getResource());
			}
		}
		
		genEntitiesJob.schedule();
		if (synchClassesJob != null) {
			synchClassesJob.schedule();
		}		
		
		return true;
	}
	
	// ********** generate entities job **********

	static class GenerateEntitiesJob extends WorkspaceJob {
		JpaProject jpaProject ;
		ORMGenCustomizer customizer;
		GenerateEntitiesJob(JpaProject jpaProject, ORMGenCustomizer customizer) {
			super(JptUiMessages.EntitiesGenerator_jobName);
			this.customizer = customizer;
			this.jpaProject = jpaProject ;
			this.setRule(jpaProject.getProject());
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
			PackageGenerator2.generate(jpaProject.getJavaProject(),this.customizer, monitor);
			return Status.OK_STATUS;
		}

	}	

	private DatabaseAnnotationNameBuilder buildDatabaseAnnotationNameBuilder() {
		return new LocalDatabaseAnnotationNameBuilder(this.jpaProject.getJpaPlatform().getEntityGeneratorDatabaseAnnotationNameBuilder());
	}

	// ********** name builder adapter **********

	/**
	 * adapt the JPA platform-supplied builder to the builder interface
	 * expected by the entity generator
	 */
	static class LocalDatabaseAnnotationNameBuilder implements DatabaseAnnotationNameBuilder {
		private EntityGeneratorDatabaseAnnotationNameBuilder builder;
		LocalDatabaseAnnotationNameBuilder(EntityGeneratorDatabaseAnnotationNameBuilder builder) {
			super();
			this.builder = builder;
		}
		public String buildTableAnnotationName(String entityName, Table table) {
			return this.builder.buildTableAnnotationName(entityName, table);
		}
		public String buildColumnAnnotationName(String attributeName, Column column) {
			return this.builder.buildColumnAnnotationName(attributeName, column);
		}
		public String buildJoinColumnAnnotationName(String attributeName, ForeignKey foreignKey) {
			return this.builder.buildJoinColumnAnnotationName(attributeName, foreignKey);
		}
		public String buildJoinColumnAnnotationName(Column column) {
			return this.builder.buildJoinColumnAnnotationName(column);
		}
		public String buildJoinTableAnnotationName(Table table) {
			return this.builder.buildJoinTableAnnotationName(table);
		}
	}
	
	@Override
    public IWizardPage getStartingPage() {
		if (this.projectPage != null) {
			if (this.tablesSelectorPage != null)
				return this.tablesSelectorPage;
			else
				return this.projectPage;
		}
		else
			return super.getStartingPage();
    }
	
	public ORMGenCustomizer getCustomizer (){
		return customizer;
	} 
	Collection<Table> getPossibleTables() {
		if ( this.tablesSelectorPage != null) {
			return this.tablesSelectorPage.getTables();
		}
		return ( this.projectDefaultSchemaExists()) ? CollectionTools.collection( this.getDefaultSchema().tables()) : Collections.<Table>emptyList();
	}
	
	public ConnectionProfile getProjectConnectionProfile() {
		return this.jpaProject.getConnectionProfile();
	}
	
	public JpaProject getJpaProject(){
		return this.jpaProject;
	}
	
	public void setJpaProject(JpaProject jpaProject) {
		if (this.jpaProject == null) {
			this.jpaProject = jpaProject;
			IWizardPage currentPage = getContainer().getCurrentPage();
			if (projectPage != null && currentPage.equals(projectPage)) {
				addMainPages();
			}
		}
	}

	public Schema getDefaultSchema() {
		return getJpaProject().getDefaultDbSchema() ;
	}

	private boolean projectDefaultSchemaExists() {
		return ( this.getDefaultSchema() != null);
	}

	public boolean synchronizePersistenceXml() {
		return this.synchronizePersistenceXml;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		Object sel = selection.getFirstElement();
		if( sel instanceof IResource ){
			IProject proj = ((IResource) sel).getProject();
			JpaProject jpaProj = JptCorePlugin.getJpaProject( proj );
			this.jpaProject = jpaProj;
		}else if( sel instanceof org.eclipse.jdt.core.IPackageFragmentRoot ){
			org.eclipse.jdt.core.IPackageFragmentRoot root = (org.eclipse.jdt.core.IPackageFragmentRoot)sel;
			IProject proj = root.getJavaProject().getProject();
			JpaProject jpaProj = JptCorePlugin.getJpaProject( proj );
			this.jpaProject = jpaProj;
		}else if( sel instanceof org.eclipse.jdt.core.IPackageFragment){
			org.eclipse.jdt.core.IPackageFragment frag = (org.eclipse.jdt.core.IPackageFragment)sel;
			IProject proj = frag.getJavaProject().getProject();
			JpaProject jpaProj = JptCorePlugin.getJpaProject( proj );
			this.jpaProject = jpaProj;
		}
		
		this.selection = selection;
		this.setWindowTitle( JptUiEntityGenMessages.GenerateEntitiesWizard_generateEntities);
		
	}
	
    public boolean openConfirmDialog() {
    	Shell parent = Display.getDefault().getActiveShell();
    	String title = JptUiEntityGenMessages.WarningDialogTitle; 
    	String message = JptUiEntityGenMessages.GenerateEntitiesWizard_fileWillBeOverwritten;
    	WarnOverwriteDialog dialog = new WarnOverwriteDialog(parent, title, null, // accept
                // the
                // default
                // window
                // icon
                message, MessageDialog.QUESTION, new String[] { IDialogConstants.OK_LABEL,
                        IDialogConstants.CANCEL_LABEL }, 0); // OK is the
        // default
        return dialog.open() == 0;
    }

}

/**
 * A simple dialog displaying warning message that existing files would be overwritten 
 */
class WarnOverwriteDialog extends MessageDialog {
    static final String DONT_SHOW_OVERWRITE_WARNING = "DONT_SHOW_OVERWRITE_WARNING"; //$NON-NLS-1$

	public WarnOverwriteDialog (Shell parentShell, String dialogTitle,
            Image dialogTitleImage, String dialogMessage, int dialogImageType,
            String[] dialogButtonLabels, int defaultIndex) {
        super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType,
        		dialogButtonLabels, defaultIndex);
    }
    
    @Override
    protected Control createCustomArea(Composite composite) {
    	final Button checkbox = new Button( composite, SWT.CHECK );
    	checkbox.setText( JptUiEntityGenMessages.GenerateEntitiesWizard_doNotShowWarning );
    	checkbox.setSelection(false);
    	final IEclipsePreferences pref = new InstanceScope().getNode( JptUiPlugin.PLUGIN_ID); 
    	checkbox.setLayoutData( new GridData(GridData.FILL_BOTH) );
    	checkbox.addSelectionListener(new SelectionListener (){
    		public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				boolean b = checkbox.getSelection();
                if( b ){
                	pref.putBoolean( DONT_SHOW_OVERWRITE_WARNING, true);
                }
			}
    	});
    	return checkbox;
    }
    
    public static boolean shouldShowDialog(){
    	IEclipsePreferences pref = new InstanceScope().getNode( JptUiPlugin.PLUGIN_ID); 
    	boolean ret = ! pref.getBoolean( DONT_SHOW_OVERWRITE_WARNING, true) ;
    	return( ret );
    }
}
