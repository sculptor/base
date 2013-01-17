/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.AddTask#getFindDOWith <em>Find DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getAddTask()
 * @model
 * @generated
 */
public interface AddTask extends UserTask {
    /**
     * Returns the value of the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Find DO With</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Find DO With</em>' reference.
     * @see #setFindDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getAddTask_FindDOWith()
     * @model
     * @generated
     */
    ServiceOperation getFindDOWith();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.AddTask#getFindDOWith <em>Find DO With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Find DO With</em>' reference.
     * @see #getFindDOWith()
     * @generated
     */
    void setFindDOWith(ServiceOperation value);

} // AddTask
