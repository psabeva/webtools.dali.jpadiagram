/*******************************************************************************
 * Copyright (c) 2007, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.ui.internal.wizards;

import org.eclipse.jpt.common.ui.internal.WorkbenchTools;
import org.eclipse.jpt.common.ui.internal.swt.widgets.ControlTools;
import org.eclipse.jpt.common.utility.internal.ArrayTools;
import org.eclipse.jpt.jpa.core.JpaWorkspace;
import org.eclipse.jpt.jpa.core.internal.facet.JpaFacetInstallDataModelProperties;
import org.eclipse.jpt.jpa.db.ConnectionProfile;
import org.eclipse.jpt.jpa.db.ConnectionProfileFactory;
import org.eclipse.jpt.jpa.db.ui.internal.DTPUiTools;
import org.eclipse.jpt.jpa.ui.JpaWorkbench;
import org.eclipse.jpt.jpa.ui.JptJpaUiMessages;
import org.eclipse.jpt.jpa.ui.internal.JpaHelpContextIds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

public class JpaFacetInstallPage
	extends JpaFacetActionPage
	implements JpaFacetInstallDataModelProperties
{
	public JpaFacetInstallPage() {
		super("jpt.jpa.facet.install.page"); //$NON-NLS-1$
	}
	
	
	@Override
	protected Composite createTopLevelComposite(Composite parent) {
		Composite composite = super.createTopLevelComposite(parent);
		WorkbenchTools.setHelp(composite, JpaHelpContextIds.NEW_JPA_PROJECT_JPA_FACET);
		return composite;
	}
	
	@Override
	protected void addSubComposites(Composite composite) {
		new PlatformGroup(composite);
		new ClasspathConfigGroup(composite);
		new ConnectionGroup(composite);
		new PersistentClassManagementGroup(composite);
	}
	
	@Override
	protected String[] getValidationPropertyNames() {
		String[] validationPropertyNames = super.getValidationPropertyNames();
		return ArrayTools.addAll(
				validationPropertyNames,
				USER_WANTS_TO_ADD_DB_DRIVER_JARS_TO_CLASSPATH,
				DB_DRIVER_NAME);
	}
	
	
	protected final class ConnectionGroup
	{
		private final Combo connectionCombo;
		
		private final Link connectionLink;
		
		private final Link connectLink;
		
		private final Button addDriverLibraryButton;
		
		private final Label driverLibraryLabel;
		
		private final Combo driverLibraryCombo;
		
		private final Button overrideDefaultCatalogButton;
		
		private final Label defaultCatalogLabel;
		
		private final Combo defaultCatalogCombo;
		
		private final Button overrideDefaultSchemaButton;
		
		private final Label defaultSchemaLabel;
		
		private final Combo defaultSchemaCombo;
		
		
		public ConnectionGroup(Composite composite) {
			Group group = new Group(composite, SWT.NONE);
			group.setText(JptJpaUiMessages.JpaFacetWizardPage_connectionLabel);
			group.setLayout(new GridLayout(3, false));
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			WorkbenchTools.setHelp(group, JpaHelpContextIds.NEW_JPA_PROJECT_CONTENT_PAGE_DATABASE);
			
			connectionCombo = createCombo(group, 3, true);
			synchHelper.synchCombo(connectionCombo, CONNECTION, null);
			connectionCombo.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						updateConnectionStatus();
					}
				});
			
			connectionLink = new Link(group, SWT.NONE);
			GridData data = new GridData(GridData.END, GridData.CENTER, false, false);
			data.horizontalSpan = 2;
			connectionLink.setLayoutData(data);
			connectionLink.setText(JptJpaUiMessages.JpaFacetWizardPage_connectionLink);
			connectionLink.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						openNewConnectionWizard();
					}
				}
			);
			
			connectLink = new Link(group, SWT.NONE);
			data = new GridData(GridData.END, GridData.CENTER, false, false);
			data.horizontalSpan = 2;
			connectLink.setLayoutData(data);
			connectLink.setText(JptJpaUiMessages.JpaFacetWizardPage_connectLink);
			connectLink.setEnabled(false);
			connectLink.addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						openConnectionProfile();
					}
				});
			
			addDriverLibraryButton = createButton(group, 3, JptJpaUiMessages.JpaFacetWizardPage_addDriverLibraryLabel, SWT.CHECK);
			addDriverLibraryButton.setSelection(false);
			synchHelper.synchCheckbox(addDriverLibraryButton, USER_WANTS_TO_ADD_DB_DRIVER_JARS_TO_CLASSPATH, null);
			
			driverLibraryLabel = new Label(group, SWT.LEFT);
			driverLibraryLabel.setText(JptJpaUiMessages.JpaFacetWizardPage_driverLibraryLabel);
			GridData gd = new GridData();
			gd.horizontalSpan = 1;
			driverLibraryLabel.setLayoutData(gd);
			
			driverLibraryCombo = createCombo(group, 1, true);
			synchHelper.synchCombo(
				driverLibraryCombo, DB_DRIVER_NAME, 
				new Control[] {driverLibraryLabel});
			
			overrideDefaultCatalogButton = createButton(group, 3, JptJpaUiMessages.JpaFacetWizardPage_overrideDefaultCatalogLabel, SWT.CHECK);
			overrideDefaultCatalogButton.setSelection(false);
			synchHelper.synchCheckbox(overrideDefaultCatalogButton, USER_WANTS_TO_OVERRIDE_DEFAULT_CATALOG, null);
			
			defaultCatalogLabel = new Label(group, SWT.LEFT);
			defaultCatalogLabel.setText(JptJpaUiMessages.JpaFacetWizardPage_defaultCatalogLabel);
			gd = new GridData();
			gd.horizontalSpan = 1;
			defaultCatalogLabel.setLayoutData(gd);
			
			defaultCatalogCombo = createCombo(group, 1, true);
			synchHelper.synchCombo(
				defaultCatalogCombo, USER_OVERRIDE_DEFAULT_CATALOG, 
				new Control[] {defaultCatalogLabel});
			
			overrideDefaultSchemaButton = createButton(group, 3, JptJpaUiMessages.JpaFacetWizardPage_overrideDefaultSchemaLabel, SWT.CHECK);
			overrideDefaultSchemaButton.setSelection(false);
			synchHelper.synchCheckbox(overrideDefaultSchemaButton, USER_WANTS_TO_OVERRIDE_DEFAULT_SCHEMA, null);
			
			defaultSchemaLabel = new Label(group, SWT.LEFT);
			defaultSchemaLabel.setText(JptJpaUiMessages.JpaFacetWizardPage_defaultSchemaLabel);
			gd = new GridData();
			gd.horizontalSpan = 1;
			defaultSchemaLabel.setLayoutData(gd);
			
			defaultSchemaCombo = createCombo(group, 1, true);
			synchHelper.synchCombo(
				defaultSchemaCombo, USER_OVERRIDE_DEFAULT_SCHEMA, 
				new Control[] {defaultSchemaLabel});
		}
		
		private void openNewConnectionWizard() {
			String connectionName = DTPUiTools.createNewConnectionProfile();
			if (connectionName != null) {
				model.setProperty(CONNECTION, connectionName);
				updateConnectionStatus();
			}
		}
		
		private void openConnectionProfile() {
			ConnectionProfile cp = getConnectionProfile();
			if (cp != null) {
				cp.connect();
				model.setBooleanProperty(CONNECTION_ACTIVE, cp.isActive());
				updateConnectionStatus();
			}
		}
		
		private void updateConnectionStatus() {
			ConnectionProfile cp = this.getConnectionProfile();
			updateConnectLink(cp);
			addDriverLibraryButton.setEnabled(cp != null);
		}
		
		private ConnectionProfile getConnectionProfile() {
			// we just use the connection profile to log in, so go to the the db plug-in
			ConnectionProfileFactory factory = this.getConnectionProfileFactory();
			return (factory == null) ? null : factory.buildConnectionProfile(model.getStringProperty(CONNECTION));
		}

		private ConnectionProfileFactory getConnectionProfileFactory() {
			JpaWorkspace jpaWorkspace = this.getJpaWorkspace();
			return (jpaWorkspace == null) ? null : jpaWorkspace.getConnectionProfileFactory();
		}

		private JpaWorkspace getJpaWorkspace() {
			JpaWorkbench jpaWorkbench = this.getJpaWorkbench();
			return (jpaWorkbench == null) ? null : jpaWorkbench.getJpaWorkspace();
		}
	
		private JpaWorkbench getJpaWorkbench() {
			return WorkbenchTools.getAdapter(JpaWorkbench.class);
		}

		private void updateConnectLink(ConnectionProfile cp) {
			connectLink.setEnabled((cp != null) && cp.isDisconnected());
			if (cp != null && cp.isConnected()) {
				updateConnectLinkText(JptJpaUiMessages.JpaFacetWizardPage_connectedText);
			}
			else {
				updateConnectLinkText(JptJpaUiMessages.JpaFacetWizardPage_connectLink);
			}
		}
		
		private void updateConnectLinkText(String text) {
			connectLink.setText(text);
			ControlTools.reflow(connectLink);
		}
	}
}
