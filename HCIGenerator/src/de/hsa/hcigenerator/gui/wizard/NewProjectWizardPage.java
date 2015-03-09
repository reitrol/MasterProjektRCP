package de.hsa.hcigenerator.gui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewProjectWizardPage extends WizardPage {

	protected NewProjectWizardPage(String pageName) {
		super(pageName);
		setTitle(pageName);
        setDescription("Example wizard page");
	}

	@Override
	public void createControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NULL);
        setControl(container);

        container.setLayout(new GridLayout(2, false));

        Label lblName = new Label(container, SWT.NONE);
        lblName.setText("Name:");

        Text text = new Text(container, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}

}
