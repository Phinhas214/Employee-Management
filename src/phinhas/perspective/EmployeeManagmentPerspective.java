package phinhas.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class EmployeeManagmentPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		
		String editorId = layout.getEditorArea();
		
		
		
		String countriesId = "phinhas.views.countries";
		String regionsId = "phinhas.views.regions";
		String departmentsId = "phinhas.views.departments";
		String managementHierarchyId = "phinhas.views.managementHierarchy";
		String jobsId = "phinhas.views.jobs";
		
		// left side layout on reference to editor area
		layout.addStandaloneView("phinhas.views.regions", true, IPageLayout.LEFT, 0.27f, layout.getEditorArea());
		layout.addStandaloneView(countriesId, true, IPageLayout.BOTTOM, 0.3f, regionsId);
		layout.addStandaloneView(departmentsId, true, IPageLayout.BOTTOM, 0.46f, countriesId);
		
		// right side layout on reference to editor area	
		layout.addStandaloneView(managementHierarchyId, true, IPageLayout.RIGHT, 0.62f, editorId);
		layout.addStandaloneView(jobsId, true, IPageLayout.BOTTOM, 0.48f, managementHierarchyId);
		
		// creating the folder tab view at the bottom of the editor
		IFolderLayout tabView = layout.createFolder("EmployeeDetails", IPageLayout.BOTTOM, 0.62f, editorId);
		tabView.addView(IPageLayout.ID_PROP_SHEET);
		tabView.addView(IPageLayout.ID_BOOKMARKS);
		
	}

}
