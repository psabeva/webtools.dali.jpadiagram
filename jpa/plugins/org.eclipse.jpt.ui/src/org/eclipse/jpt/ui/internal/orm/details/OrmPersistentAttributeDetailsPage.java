/*******************************************************************************
 * Copyright (c) 2006, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.ui.internal.orm.details;

import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jpt.core.context.AttributeMapping;
import org.eclipse.jpt.core.context.PersistentAttribute;
import org.eclipse.jpt.core.context.orm.OrmAttributeMapping;
import org.eclipse.jpt.core.context.orm.OrmPersistentAttribute;
import org.eclipse.jpt.ui.WidgetFactory;
import org.eclipse.jpt.ui.details.AttributeMappingUiProvider;
import org.eclipse.jpt.ui.details.DefaultAttributeMappingUiProvider;
import org.eclipse.jpt.ui.details.JpaComposite;
import org.eclipse.jpt.ui.internal.details.PersistentAttributeDetailsPage;
import org.eclipse.jpt.ui.internal.mappings.details.OrmPersistentAttributeMapAsComposite;
import org.eclipse.jpt.ui.internal.util.PaneEnabler;
import org.eclipse.jpt.ui.internal.widgets.Pane;
import org.eclipse.jpt.utility.internal.CollectionTools;
import org.eclipse.jpt.utility.internal.model.value.TransformationPropertyValueModel;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.PageBook;

/**
 * The default implementation of the details page used for the XML persistent
 * attribute.
 * <p>
 * Here the layout of this pane:
 * <pre>
 * -----------------------------------------------------------------------------
 * | ------------------------------------------------------------------------- |
 * | |                                                                       | |
 * | | OrmPersistentAttributeMapAsComposite                                  | |
 * | |                                                                       | |
 * | ------------------------------------------------------------------------- |
 * | ------------------------------------------------------------------------- |
 * | |                                                                       | |
 * | | Attribute mapping pane                                                | |
 * | |                                                                       | |
 * | ------------------------------------------------------------------------- |
 * -----------------------------------------------------------------------------</pre>
 *
 * @see OrmPersistentAttribute
 * @see OrmPersistentAttributeMapAsComposite
 *
 * @version 2.0
 * @since 2.0
 */
@SuppressWarnings("nls")
public class OrmPersistentAttributeDetailsPage extends PersistentAttributeDetailsPage<OrmPersistentAttribute>
{
	/**
	 * Creates a new <code>OrmPersistentAttributeDetailsPage</code>.
	 *
	 * @param parent The parent container
	 * @param widgetFactory The factory used to create various common widgets
	 */
	public OrmPersistentAttributeDetailsPage(Composite parent,
	                                         WidgetFactory widgetFactory) {

		super(parent, widgetFactory);
	}

	@Override
	public Iterator<AttributeMappingUiProvider<? extends AttributeMapping>> attributeMappingUiProviders() {
		return jpaPlatformUi().ormAttributeMappingUiProviders();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected AttributeMappingUiProvider<? extends AttributeMapping>[] attributeMappingUiProvidersFor(PersistentAttribute persistentAttribute) {
		//bug 192035 - no default mapping option in xml
		return CollectionTools.array(attributeMappingUiProviders(), new AttributeMappingUiProvider[CollectionTools.size(attributeMappingUiProviders())]);
	}

	private PropertyValueModel<Boolean> buildPaneEnablerHolder() {
		return new TransformationPropertyValueModel<OrmPersistentAttribute, Boolean>(getSubjectHolder()) {
			@Override
			protected Boolean transform_(OrmPersistentAttribute value) {
				return !value.isVirtual();
			}
		};
	}

	@Override
	protected DefaultAttributeMappingUiProvider<AttributeMapping> getDefaultAttributeMappingUiProvider(String key) {
		throw new UnsupportedOperationException("Xml attributeMappings should not be default");
	}

	@Override
	protected Iterator<DefaultAttributeMappingUiProvider<? extends AttributeMapping>> defaultAttributeMappingUiProviders() {
		return jpaPlatformUi().defaultOrmAttributeMappingUiProviders();
	}

	private PropertyValueModel<OrmAttributeMapping> getMappingHolder() {
		return new TransformationPropertyValueModel<PersistentAttribute, OrmAttributeMapping>(getSubjectHolder()) {
			@Override
			protected OrmAttributeMapping transform_(PersistentAttribute value) {
				return (OrmAttributeMapping) value.getMapping();
			}
		};
	}

	@Override
	protected void initializeLayout(Composite container) {

		ArrayList<Pane<?>> panes = new ArrayList<Pane<?>>(2);

		// Map As composite
		OrmPersistentAttributeMapAsComposite mapAsPane = new OrmPersistentAttributeMapAsComposite(
			this,
			addSubPane(container, 0, 0, 5, 0)
		);

		panes.add(mapAsPane);

		// Entity type widgets
		OrmJavaAttributeChooser javaAttributePane =
			new OrmJavaAttributeChooser(this, getMappingHolder(), container);

		panes.add(javaAttributePane);

		// Mapping properties pane
		PageBook attributePane = buildMappingPageBook(container);

		GridData gridData = new GridData();
		gridData.horizontalAlignment       = SWT.FILL;
		gridData.verticalAlignment         = SWT.TOP;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace   = true;

		attributePane.setLayoutData(gridData);

		installPaneEnabler(panes);
	}

	private void installPaneEnabler(ArrayList<Pane<?>> panes) {
		new PaneEnabler(buildPaneEnablerHolder(), panes);
	}

	@Override
	protected void mappingPageChanged(JpaComposite mappingComposite) {
		if (mappingComposite == null) {
			return;
		}
		boolean enabled = false;

		if (getSubject() != null && getSubject().getParent() != null) {
			enabled = !getSubject().isVirtual();
		}

		mappingComposite.enableWidgets(enabled);
	}
}