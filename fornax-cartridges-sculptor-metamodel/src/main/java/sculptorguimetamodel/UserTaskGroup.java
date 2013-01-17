/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import sculptormetamodel.DomainObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Task Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.UserTaskGroup#getUserTasks <em>User Tasks</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTaskGroup#getFor <em>For</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTaskGroup#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTaskGroup()
 * @model
 * @generated
 */
public interface UserTaskGroup extends EObject {
	/**
     * Returns the value of the '<em><b>User Tasks</b></em>' reference list.
     * The list contents are of type {@link sculptorguimetamodel.UserTask}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>User Tasks</em>' reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTaskGroup_UserTasks()
     * @model type="sculptorguimetamodel.UserTask"
     * @generated
     */
	EList getUserTasks();

    /**
     * Returns the value of the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>For</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>For</em>' reference.
     * @see #setFor(DomainObject)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTaskGroup_For()
     * @model
     * @generated
     */
    DomainObject getFor();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.UserTaskGroup#getFor <em>For</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>For</em>' reference.
     * @see #getFor()
     * @generated
     */
    void setFor(DomainObject value);

    /**
     * Returns the value of the '<em><b>Module</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Module</em>' reference.
     * @see #setModule(GuiModule)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTaskGroup_Module()
     * @model
     * @generated
     */
    GuiModule getModule();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.UserTaskGroup#getModule <em>Module</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Module</em>' reference.
     * @see #getModule()
     * @generated
     */
    void setModule(GuiModule value);

} // UserTaskGroup
