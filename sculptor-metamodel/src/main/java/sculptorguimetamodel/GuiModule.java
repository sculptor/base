/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;

import sculptormetamodel.Module;
import sculptormetamodel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gui Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.GuiModule#getUserTasks <em>User Tasks</em>}</li>
 *   <li>{@link sculptorguimetamodel.GuiModule#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link sculptorguimetamodel.GuiModule#getApplication <em>Application</em>}</li>
 *   <li>{@link sculptorguimetamodel.GuiModule#getFor <em>For</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiModule()
 * @model
 * @generated
 */
public interface GuiModule extends NamedElement {
	/**
     * Returns the value of the '<em><b>User Tasks</b></em>' containment reference list.
     * The list contents are of type {@link sculptorguimetamodel.UserTask}.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.UserTask#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>User Tasks</em>' containment reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiModule_UserTasks()
     * @see sculptorguimetamodel.UserTask#getModule
     * @model type="sculptorguimetamodel.UserTask" opposite="module" containment="true" required="true"
     * @generated
     */
	EList getUserTasks();

	/**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiModule_BasePackage()
     * @model
     * @generated
     */
	String getBasePackage();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.GuiModule#getBasePackage <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
	void setBasePackage(String value);

	/**
     * Returns the value of the '<em><b>Application</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.GuiApplication#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Application</em>' container reference.
     * @see #setApplication(GuiApplication)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiModule_Application()
     * @see sculptorguimetamodel.GuiApplication#getModules
     * @model opposite="modules" transient="false"
     * @generated
     */
	GuiApplication getApplication();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.GuiModule#getApplication <em>Application</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Application</em>' container reference.
     * @see #getApplication()
     * @generated
     */
	void setApplication(GuiApplication value);

    /**
     * Returns the value of the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>For</em>' reference.
     * @see #setFor(Module)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiModule_For()
     * @model
     * @generated
     */
    Module getFor();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.GuiModule#getFor <em>For</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For</em>' reference.
     * @see #getFor()
     * @generated
     */
    void setFor(Module value);

} // GuiModule
