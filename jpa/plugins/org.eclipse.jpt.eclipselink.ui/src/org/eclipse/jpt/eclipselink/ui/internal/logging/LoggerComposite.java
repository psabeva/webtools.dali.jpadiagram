/*******************************************************************************
* Copyright (c) 2008 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License v1.0, which accompanies this distribution
* and is available at http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
*******************************************************************************/
package org.eclipse.jpt.eclipselink.ui.internal.logging;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.jpt.eclipselink.core.internal.context.logging.Logger;
import org.eclipse.jpt.eclipselink.core.internal.context.logging.Logging;
import org.eclipse.jpt.eclipselink.ui.internal.EclipseLinkUiMessages;
import org.eclipse.jpt.ui.internal.util.SWTUtil;
import org.eclipse.jpt.ui.internal.widgets.AbstractPane;
import org.eclipse.jpt.utility.internal.CollectionTools;
import org.eclipse.jpt.utility.internal.StringConverter;
import org.eclipse.jpt.utility.internal.iterators.TransformationIterator;
import org.eclipse.jpt.utility.internal.model.value.CompositeListValueModel;
import org.eclipse.jpt.utility.internal.model.value.PropertyAspectAdapter;
import org.eclipse.jpt.utility.internal.model.value.PropertyListValueModelAdapter;
import org.eclipse.jpt.utility.internal.model.value.SimpleCollectionValueModel;
import org.eclipse.jpt.utility.internal.model.value.SortedListValueModelAdapter;
import org.eclipse.jpt.utility.model.value.CollectionValueModel;
import org.eclipse.jpt.utility.model.value.ListValueModel;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.jpt.utility.model.value.WritablePropertyValueModel;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

/**
 *  LoggerComposite
 */
public class LoggerComposite extends AbstractPane<Logging>
{
	/**
	 * Creates a new <code>LoggerComposite</code>.
	 *
	 * @param parentPane The parent container of this one
	 * @param parent The parent container
	 */
	public LoggerComposite(
								AbstractPane<? extends Logging> parentPane,
	                           Composite parent) {

		super(parentPane, parent);
	}

	private PropertyValueModel<String> buildDefaultLoggerHolder() {
		return new PropertyAspectAdapter<Logging, String>(this.getSubjectHolder(), Logging.DEFAULT_LOGGER) {
			@Override
			protected String buildValue_() {
				return LoggerComposite.this.defaultValue(subject);
			}
		};
	}

	private ListValueModel<String> buildDefaultLoggerListHolder() {
		return new PropertyListValueModelAdapter<String>(
			this.buildDefaultLoggerHolder()
		);
	}

	private String buildDisplayString(String loggerName) {

		switch (Logger.valueOf(loggerName)) {
			case default_logger: {
				return EclipseLinkUiMessages.LoggerComposite_default_logger;
			}
			case java_logger: {
				return EclipseLinkUiMessages.LoggerComposite_java_logger;
			}
			case server_logger: {
				return EclipseLinkUiMessages.LoggerComposite_server_logger;
			}
			default: {
				return null;
			}
		}
	}

	private Comparator<String> buildLoggerComparator() {
		return new Comparator<String>() {
			public int compare(String logger1, String logger2) {
				logger1 = buildDisplayString(logger1);
				logger2 = buildDisplayString(logger2);
				return Collator.getInstance().compare(logger1, logger2);
			}
		};
	}

	private StringConverter<String> buildLoggerConverter() {
		return new StringConverter<String>() {
			public String convertToString(String value) {
				try {
					Logger.valueOf(value);
					value = buildDisplayString(value);
				}
				catch (Exception e) {
					// Ignore since the value is not a Logger
				}
				return value;
			}
		};
	}

	private WritablePropertyValueModel<String> buildLoggerHolder() {
		return new PropertyAspectAdapter<Logging, String>(this.getSubjectHolder(), Logging.LOGGER_PROPERTY) {
			@Override
			protected String buildValue_() {

				String name = subject.getLogger();
				if (name == null) {
					name = LoggerComposite.this.defaultValue(subject);
				}
				return name;
			}

			@Override
			protected void setValue_(String value) {

				if (defaultValue(subject).equals(value)) {
					value = null;
				}
				subject.setLogger(value);
			}
		};
	}

	private ListValueModel<String> buildLoggerListHolder() {
		ArrayList<ListValueModel<String>> holders = new ArrayList<ListValueModel<String>>(2);
		holders.add(buildDefaultLoggerListHolder());
		holders.add(buildLoggersListHolder());
		return new CompositeListValueModel<ListValueModel<String>, String>(holders);
	}

	private Iterator<String> buildLoggers() {
		return new TransformationIterator<Logger, String>(CollectionTools.iterator(Logger.values())) {
			@Override
			protected String transform(Logger next) {
				return next.name();
			}
		};
	}

	private CollectionValueModel<String> buildLoggersCollectionHolder() {
		return new SimpleCollectionValueModel<String>(
			CollectionTools.collection(buildLoggers())
		);
	}

	private ListValueModel<String> buildLoggersListHolder() {
		return new SortedListValueModelAdapter<String>(
			buildLoggersCollectionHolder(),
			buildLoggerComparator()
		);
	}

	private String defaultValue(Logging subject) {
		String defaultValue = subject.getDefaultLogger();

		if (defaultValue != null) {
			return NLS.bind(
				EclipseLinkUiMessages.PersistenceXmlLoggingTab_defaultWithOneParam,
				defaultValue
			);
		}
		else {
			return EclipseLinkUiMessages.PersistenceXmlLoggingTab_defaultEmpty;
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void initializeLayout(Composite container) {

		CCombo combo = buildLabeledEditableCCombo(
			container,
			EclipseLinkUiMessages.PersistenceXmlLoggingTab_loggerLabel,
			this.buildLoggerListHolder(),
			this.buildLoggerHolder(),
			this.buildLoggerConverter(),
			null		// EclipseLinkHelpContextIds.LOGGER_NAME
		);

		SWTUtil.attachDefaultValueHandler(combo);
	}
}