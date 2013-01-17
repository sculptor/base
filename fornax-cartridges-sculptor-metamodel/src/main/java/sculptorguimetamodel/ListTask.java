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
 * A representation of the model object '<em><b>List Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.ListTask#getSearchDOWith <em>Search DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getListTask()
 * @model
 * @generated
 */
public interface ListTask extends UserTask {
	/**
     * Returns the value of the '<em><b>Search DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search DO With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Search DO With</em>' reference.
     * @see #setSearchDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getListTask_SearchDOWith()
     * @model
     * @generated
     */
	ServiceOperation getSearchDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.ListTask#getSearchDOWith <em>Search DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Search DO With</em>' reference.
     * @see #getSearchDOWith()
     * @generated
     */
	void setSearchDOWith(ServiceOperation value);

} // ListTask
