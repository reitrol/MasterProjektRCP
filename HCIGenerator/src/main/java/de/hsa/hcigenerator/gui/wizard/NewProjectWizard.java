package de.hsa.hcigenerator.gui.wizard;

import org.eclipse.jface.wizard.Wizard;

public class NewProjectWizard extends Wizard {

	@Override
	public void addPages() {
		addPage(new NewProjectWizardPage("page 1"));
		addPage(new NewProjectWizardPage("page 2"));
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return true;
	}

}
