/*******************************************************************************
 * Copyright (c) 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.ui.internal.widgets;

import org.eclipse.jpt.ui.internal.JptUiMessages;
import org.eclipse.jpt.utility.model.Model;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A chooser is simply a pane with three widgets, the label on the left, a main
 * widget, usually a text field, and a right widget which is usually a browse
 * button.
 *
 * @see ClassChooserPane
 * @see PackageChooserPane
 *
 * @version 2.0
 * @since 2.0
 */
public abstract class AbstractChooserPane<T extends Model> extends AbstractPane<T>
{
	/**
	 * The control shown after the label (left control).
	 */
	private Control mainControl;

	/**
	 * The control shown after the main control.
	 */
	private Control rightControl;

	/**
	 * Creates a new <code>AbstractChooserPane</code>.
	 *
	 * @param parentPane The parent pane of this one
	 * @param parent The parent container
	 */
	public AbstractChooserPane(AbstractPane<? extends T> parentPane,
	                           Composite parent) {

		super(parentPane, parent);
	}

	/**
	 * Creates a new <code>AbstractChooserPane</code>.
	 *
	 * @param parentPane The parent container of this one
	 * @param subjectHolder The holder of this pane's subject
	 * @param parent The parent container
	 */
	public AbstractChooserPane(AbstractPane<?> parentPane,
	                           PropertyValueModel<? extends T> subjectHolder,
	                           Composite parent) {

		super(parentPane, subjectHolder, parent);
	}

	/**
	 * Returns the text of the browse button. This method is called by
	 * {@link #buildRightControl(Composite)}.
	 *
	 * @return "Browse..."
	 */
	protected String browseButtonText() {
		return JptUiMessages.AbstractChooserPane_browseButton;
	}

	/**
	 * Creates the action responsible to perform the action when the Browse is
	 * clicked.
	 *
	 * @return A new <code>Runnable</code> performing the actual action of the
	 * button
	 */
	protected abstract Runnable buildBrowseAction();

	/**
	 * Creates the left control. By default a label is created and its text is
	 * retrieved by {@link #labelText()}.
	 *
	 * @param container The parent container
	 * @return The newly created left control
	 */
	protected Control buildLeftControl(Composite container) {
		return buildLabel(container, labelText());
	}

	/**
	 * Creates the main control of this pane.
	 *
	 * @param container The parent container
	 * @return The newly created main control
	 */
	protected abstract Control buildMainControl(Composite container);

	/**
	 * Creates the right control. By default a browse button is created and its
	 * action is performed by {@link #buildBrowseAction()} and its text is
	 * retrieved by {@link #browseButtonText()}.
	 *
	 * @param container The parent container
	 * @return The newly created right control
	 */
	protected Control buildRightControl(Composite container) {
		return buildButton(
			container,
			browseButtonText(),
			buildBrowseAction()
		);
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public void enableWidgets(boolean enabled) {

		super.enableWidgets(enabled);

		if (!mainControl.isDisposed()) {
			mainControl.setEnabled(enabled);
		}

		if (!rightControl.isDisposed()) {
			rightControl.setEnabled(enabled);
		}
	}

	/**
	 * Returns the help topic ID for the controls of this pane.
	 *
	 * @return <code>null</code> is returned otherwise the subclass can return an ID
	 */
	protected String helpId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void initializeLayout(Composite container) {

		mainControl  = buildMainControl(container);
		rightControl = buildRightControl(container);

		buildLabeledComposite(
			container,
			buildLeftControl(container),
			mainControl,
			rightControl,
			helpId()
		);
	}

	/**
	 * The text of the label. This method is called by
	 * {@link #buildLeftControl(Composite)}.
	 *
	 * @return The localized text of the left control (which is a label by
	 * default)
	 */
	protected abstract String labelText();
}
