/*******************************************************************************
 * Copyright (c) 2008, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.ui.internal.swt.bind;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.widgets.Form;

/**
 * Adapt a form to the <em>label</em> interface.
 * @see Form
 */
final class FormLabelAdapter
	extends ControlLabelAdapter<Form>
{
	public FormLabelAdapter(Form form) {
		super(form);
	}

	@Override
	protected void setImage_(Image image) {
		this.control.setImage(image);
	}

	@Override
	protected void setText_(String text) {
		this.control.setText(text);
	}
}
