/*******************************************************************************
* Copyright (c) 2008 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License v1.0, which accompanies this distribution
* and is available at http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
*******************************************************************************/
package org.eclipse.jpt.eclipselink.ui.internal.connection;

import org.eclipse.jpt.core.context.persistence.PersistenceUnitTransactionType;
import org.eclipse.jpt.eclipselink.core.internal.context.connection.Connection;
import org.eclipse.jpt.eclipselink.ui.internal.EclipseLinkUiMessages;
import org.eclipse.jpt.ui.internal.util.PaneEnabler;
import org.eclipse.jpt.ui.internal.widgets.AbstractPane;
import org.eclipse.jpt.utility.internal.model.value.PropertyAspectAdapter;
import org.eclipse.jpt.utility.internal.model.value.TransformationPropertyValueModel;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 *  JdbcPropertiesComposite
 */
public class JdbcPropertiesComposite extends AbstractPane<Connection>
{
	public JdbcPropertiesComposite(AbstractPane<Connection> parentComposite, Composite parent) {

		super(parentComposite, parent);
	}

	private PropertyValueModel<Boolean> buildPaneEnablerHolder() {
		return new TransformationPropertyValueModel<PersistenceUnitTransactionType, Boolean>(buildTransactionTypeHolder()) {
			@Override
			protected Boolean transform(PersistenceUnitTransactionType value) {
				return value == PersistenceUnitTransactionType.RESOURCE_LOCAL;
			}
		};
	}

	private PropertyValueModel<PersistenceUnitTransactionType> buildTransactionTypeHolder() {
		return new PropertyAspectAdapter<Connection, PersistenceUnitTransactionType>(getSubjectHolder(), Connection.TRANSACTION_TYPE_PROPERTY) {
			@Override
			protected PersistenceUnitTransactionType buildValue_() {
				return subject.getTransactionType();
			}
		};
	}

	@Override
	protected void initializeLayout(Composite container) {

		container = buildTitledPane(
			buildSubPane(container, 10),
			EclipseLinkUiMessages.JdbcPropertiesComposite_EclipseLinkConnectionPool_GroupBox
		);

		new JdbcConnectionPropertiesComposite(this, container);

		container = buildPane(container, new GridLayout(2, true));

		new JdbcReadConnectionPropertiesComposite(this, container);
		new JdbcWriteConnectionPropertiesComposite(this, container);

		this.installPaneEnabler();
	}

	private void installPaneEnabler() {
		new PaneEnabler(buildPaneEnablerHolder(), this);
	}
}