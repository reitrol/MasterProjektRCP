package de.hsa.hcigenerator.gui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import de.hsa.hcigenerator.gui.views.View1;
import de.hsa.hcigenerator.gui.views.View2;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();

		layout.setEditorAreaVisible(false);
		// layout.setFixed(true);

		layout.addStandaloneView(View1.ID, true, IPageLayout.LEFT, 0.25f, editorArea);

		IFolderLayout folder = layout.createFolder("messages", IPageLayout.TOP, 0.5f, editorArea);
		folder.addPlaceholder(View2.ID + ":*");
		folder.addView(View2.ID);

		layout.getViewLayout(View1.ID).setCloseable(false);

	}

}
