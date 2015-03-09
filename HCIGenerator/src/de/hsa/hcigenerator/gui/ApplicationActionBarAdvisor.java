package de.hsa.hcigenerator.gui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.NewWizardAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;

import de.hsa.hcigenerator.gui.wizard.NewProjectWizard;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.

	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction newWindowAction;
	private IAction deleteAction;

	
	private Action wizardAction;
	

	//private OpenViewAction openViewAction;
	// private Action messagePopupAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);

	/*	openViewAction = new OpenViewAction(window,
				"Open Another Message View", View.ID);
		register(openViewAction);

		messagePopupAction = new MessagePopupAction("Open Message", window);
		register(messagePopupAction);*/
		
		
		
		
		ImageDescriptor quitActionImage = AbstractUIPlugin.imageDescriptorFromPlugin("de.hsa.HCIGenerator", "icons/alt_window_16.gif" );
		
		
		// registers a new action with own form
		wizardAction = new Action() {

		      public void run() {
		        NewProjectWizard wizard = new NewProjectWizard();
		        WizardDialog dlg = new WizardDialog(window.getShell(), wizard);
		        dlg.open();
		      }
		    };
		    //wizardAction.setText( "Create new Project" );
		    wizardAction.setId( "de.hsa.hcigenerator.wizard.newproject" );
		    
		    wizardAction.setImageDescriptor( quitActionImage );
		    register( wizardAction );
		
		
	

	}
	
	
	 protected void fillMenuBar(IMenuManager menuBar) {
	        MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
	        MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
	        
	        menuBar.add(fileMenu);
	        // Add a group marker indicating where action set menus will appear.
	        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	        menuBar.add(helpMenu);
	        
	        // File
	        fileMenu.add(newWindowAction);
	        fileMenu.add(new Separator());
	        //fileMenu.add(messagePopupAction);
	        //fileMenu.add(openViewAction);
	        fileMenu.add(new Separator());
	        fileMenu.add(exitAction);
	        
	        
	        NewProjectWizard wizard = new NewProjectWizard();
	        //WizardDialog dialog = new WizardDialog(parentShell, wizard);
	        //dialog.open();
	        
	        
	        // Help
	        helpMenu.add(aboutAction);
	    }
	    
	    protected void fillCoolBar(ICoolBarManager coolBar) {
	        IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
	        coolBar.add(new ToolBarContributionItem(toolbar, "main"));   
	  
	        
	        toolbar.add(wizardAction);
	
	        //toolbar.add(openViewAction);
	        //toolbar.add(messagePopupAction);
	    }

}
