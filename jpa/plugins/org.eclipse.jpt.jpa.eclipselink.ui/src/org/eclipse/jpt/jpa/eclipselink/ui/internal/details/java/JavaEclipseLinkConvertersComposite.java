/*******************************************************************************
 * Copyright (c) 2008, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.eclipselink.ui.internal.details.java;

import org.eclipse.jpt.common.ui.internal.widgets.Pane;
import org.eclipse.jpt.common.utility.internal.model.value.PropertyAspectAdapter;
import org.eclipse.jpt.common.utility.model.value.PropertyValueModel;
import org.eclipse.jpt.common.utility.model.value.WritablePropertyValueModel;
import org.eclipse.jpt.jpa.eclipselink.core.context.EclipseLinkCustomConverter;
import org.eclipse.jpt.jpa.eclipselink.core.context.EclipseLinkObjectTypeConverter;
import org.eclipse.jpt.jpa.eclipselink.core.context.EclipseLinkStructConverter;
import org.eclipse.jpt.jpa.eclipselink.core.context.EclipseLinkTypeConverter;
import org.eclipse.jpt.jpa.eclipselink.core.context.java.JavaEclipseLinkConverterContainer;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.EclipseLinkCustomConverterComposite;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.EclipseLinkObjectTypeConverterComposite;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.EclipseLinkStructConverterComposite;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.EclipseLinkTypeConverterComposite;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.EclipseLinkUiDetailsMessages;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Here the layout of this pane:
 * <pre>
 * -----------------------------------------------------------------------------
 * | X CustomConverter                                                         |
 * |                                                                           |
 * |   ----------------------------------------------------------------------- |
 * |   |                                                                     | |
 * |   | CustomConverterComposite                                            | |
 * |   |                                                                     | |
 * |   ----------------------------------------------------------------------- |
 * |                                                                           |
 * | X Type Converter                                                          |
 * |                                                                           |
 * |   ----------------------------------------------------------------------- |
 * |   |                                                                     | |
 * |   | TypeConverterComposite                                              | |
 * |   |                                                                     | |
 * |   ----------------------------------------------------------------------- |
 * |                                                                           |
 * | X Oject Type Converter                                                    |
 * |                                                                           |
 * |   ----------------------------------------------------------------------- |
 * |   |                                                                     | |
 * |   | ObjectTypeConverterComposite                                        | |
 * |   |                                                                     | |
 * |   ----------------------------------------------------------------------- |
 * |                                                                           |
 * | X Struct Converter                                                        |
 * |                                                                           |
 * |   ----------------------------------------------------------------------- |
 * |   |                                                                     | |
 * |   | StructConverterComposite                                            | |
 * |   |                                                                     | |
 * |   ----------------------------------------------------------------------- |
 * -----------------------------------------------------------------------------</pre>
 *
 *
 * @version 2.1
 * @since 2.1
 */
public class JavaEclipseLinkConvertersComposite extends Pane<JavaEclipseLinkConverterContainer>
{

	/**
	 * Creates a new <code>ConversionComposite</code>.
	 *
	 * @param parentPane The parent container of this one
	 * @param parent The parent container
	 */
	public JavaEclipseLinkConvertersComposite(Pane<?> parentPane,
								PropertyValueModel<? extends JavaEclipseLinkConverterContainer> subjectHolder,
								Composite parent) {

		super(parentPane, subjectHolder, parent, false);
	}
	
	@Override
	protected void initializeLayout(Composite container) {

		initializeConverterPane(container);
	}
	
	private void initializeConverterPane(Composite container) {
		// Custom Converter check box
		Button customConverterCheckBox = addCheckBox(
			addSubPane(container, 5),
			EclipseLinkUiDetailsMessages.EclipseLinkConvertersComposite_customConverter,
			buildCustomConverterBooleanHolder(),
			null
		);

		// Custom Converter pane
		EclipseLinkCustomConverterComposite customConverterComposite = new EclipseLinkCustomConverterComposite(
			buildCustomConverterHolder(),
			addSubPane(container, 0, customConverterCheckBox.getBorderWidth() + 16),
			getWidgetFactory()
		);
		registerSubPane(customConverterComposite);
	
		
		// Type Converter check box
		Button typeConverterCheckBox = addCheckBox(
			addSubPane(container, 5),
			EclipseLinkUiDetailsMessages.EclipseLinkConvertersComposite_typeConverter,
			buildTypeConverterBooleanHolder(),
			null
		);

		// Type Converter pane
		EclipseLinkTypeConverterComposite typeConverterComposite = new EclipseLinkTypeConverterComposite(
			buildTypeConverterHolder(),
			addSubPane(container, 0, typeConverterCheckBox.getBorderWidth() + 16),
			getWidgetFactory()
		);
		registerSubPane(typeConverterComposite);
		
		// Object Type Converter check box
		Button objectTypeConverterCheckBox = addCheckBox(
			addSubPane(container, 5),
			EclipseLinkUiDetailsMessages.EclipseLinkConvertersComposite_objectTypeConverter,
			buildObjectTypeConverterBooleanHolder(),
			null
		);

		// Object Type Converter pane
		EclipseLinkObjectTypeConverterComposite objectTypeConverterComposite = new EclipseLinkObjectTypeConverterComposite(
			buildObjectTypeConverterHolder(),
			addSubPane(container, 0, objectTypeConverterCheckBox.getBorderWidth() + 16),
			getWidgetFactory()
		);
		registerSubPane(objectTypeConverterComposite);
		
		// Struct Converter check box
		Button structConverterCheckBox = addCheckBox(
			addSubPane(container, 5),
			EclipseLinkUiDetailsMessages.EclipseLinkConvertersComposite_structConverter,
			buildStructConverterBooleanHolder(),
			null
		);

		// Struct Converter pane
		EclipseLinkStructConverterComposite structConverterComposite = new EclipseLinkStructConverterComposite(
			buildStructConverterHolder(),
			addSubPane(container, 0, structConverterCheckBox.getBorderWidth() + 16),
			getWidgetFactory()
		);
		registerSubPane(structConverterComposite);
	}
	
	private WritablePropertyValueModel<Boolean> buildCustomConverterBooleanHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, Boolean>(getSubjectHolder(), JavaEclipseLinkConverterContainer.CUSTOM_CONVERTER_PROPERTY) {
			@Override
			protected Boolean buildValue_() {
				return Boolean.valueOf(this.subject.getCustomConverter() != null);
			}

			@Override
			protected void setValue_(Boolean value) {
				if (value.booleanValue() && (this.subject.getCustomConverter() == null)) {
					this.subject.addCustomConverter();
				}
				else if (!value.booleanValue() && (this.subject.getCustomConverter() != null)) {
					this.subject.removeCustomConverter();
				}
			}
		};
	}
	
	private PropertyValueModel<EclipseLinkCustomConverter> buildCustomConverterHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, EclipseLinkCustomConverter>(getSubjectHolder(), JavaEclipseLinkConverterContainer.CUSTOM_CONVERTER_PROPERTY) {
			@Override
			protected EclipseLinkCustomConverter buildValue_() {
				return this.subject.getCustomConverter();
			}
		};
	}
	
	private WritablePropertyValueModel<Boolean> buildTypeConverterBooleanHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, Boolean>(getSubjectHolder(), JavaEclipseLinkConverterContainer.TYPE_CONVERTER_PROPERTY) {
			@Override
			protected Boolean buildValue_() {
				return Boolean.valueOf(this.subject.getTypeConverter() != null);
			}

			@Override
			protected void setValue_(Boolean value) {
				if (value.booleanValue() && (this.subject.getTypeConverter() == null)) {
					this.subject.addTypeConverter();
				}
				else if (!value.booleanValue() && (this.subject.getTypeConverter() != null)) {
					this.subject.removeTypeConverter();
				}
			}
		};
	}
	
	private PropertyValueModel<EclipseLinkTypeConverter> buildTypeConverterHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, EclipseLinkTypeConverter>(getSubjectHolder(), JavaEclipseLinkConverterContainer.TYPE_CONVERTER_PROPERTY) {
			@Override
			protected EclipseLinkTypeConverter buildValue_() {
				return this.subject.getTypeConverter();
			}
		};
	}
	
	private WritablePropertyValueModel<Boolean> buildObjectTypeConverterBooleanHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, Boolean>(getSubjectHolder(), JavaEclipseLinkConverterContainer.OBJECT_TYPE_CONVERTER_PROPERTY) {
			@Override
			protected Boolean buildValue_() {
				return Boolean.valueOf(this.subject.getObjectTypeConverter() != null);
			}

			@Override
			protected void setValue_(Boolean value) {
				if (value.booleanValue() && (this.subject.getObjectTypeConverter() == null)) {
					this.subject.addObjectTypeConverter();
				}
				else if (!value.booleanValue() && (this.subject.getObjectTypeConverter() != null)) {
					this.subject.removeObjectTypeConverter();
				}
			}
		};
	}
	
	private PropertyValueModel<EclipseLinkObjectTypeConverter> buildObjectTypeConverterHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, EclipseLinkObjectTypeConverter>(getSubjectHolder(), JavaEclipseLinkConverterContainer.OBJECT_TYPE_CONVERTER_PROPERTY) {
			@Override
			protected EclipseLinkObjectTypeConverter buildValue_() {
				return this.subject.getObjectTypeConverter();
			}
		};
	}
	
	
	private WritablePropertyValueModel<Boolean> buildStructConverterBooleanHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, Boolean>(getSubjectHolder(), JavaEclipseLinkConverterContainer.STRUCT_CONVERTER_PROPERTY) {
			@Override
			protected Boolean buildValue_() {
				return Boolean.valueOf(this.subject.getStructConverter() != null);
			}

			@Override
			protected void setValue_(Boolean value) {
				if (value.booleanValue() && (this.subject.getStructConverter() == null)) {
					this.subject.addStructConverter();
				}
				else if (!value.booleanValue() && (this.subject.getStructConverter() != null)) {
					this.subject.removeStructConverter();
				}
			}
		};
	}
	
	private PropertyValueModel<EclipseLinkStructConverter> buildStructConverterHolder() {
		return new PropertyAspectAdapter<JavaEclipseLinkConverterContainer, EclipseLinkStructConverter>(getSubjectHolder(), JavaEclipseLinkConverterContainer.STRUCT_CONVERTER_PROPERTY) {
			@Override
			protected EclipseLinkStructConverter buildValue_() {
				return this.subject.getStructConverter();
			}
		};
	}
}