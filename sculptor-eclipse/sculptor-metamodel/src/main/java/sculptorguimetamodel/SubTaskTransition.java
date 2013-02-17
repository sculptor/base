/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.NamedElement;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Task Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.SubTaskTransition#getTo <em>To</em>}</li>
 *   <li>{@link sculptorguimetamodel.SubTaskTransition#getForReference <em>For Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.SubTaskTransition#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getSubTaskTransition()
 * @model
 * @generated
 */
public interface SubTaskTransition extends NamedElement {
	/**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(UserTask)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getSubTaskTransition_To()
     * @model
     * @generated
     */
	UserTask getTo();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.SubTaskTransition#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
	void setTo(UserTask value);

	/**
     * Returns the value of the '<em><b>For Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>For Reference</em>' reference.
     * @see #setForReference(Reference)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getSubTaskTransition_ForReference()
     * @model required="true"
     * @generated
     */
	Reference getForReference();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.SubTaskTransition#getForReference <em>For Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>For Reference</em>' reference.
     * @see #getForReference()
     * @generated
     */
	void setForReference(Reference value);

	/**
     * Returns the value of the '<em><b>From</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' reference.
     * @see #setFrom(UserTask)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getSubTaskTransition_From()
     * @model
     * @generated
     */
	UserTask getFrom();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.SubTaskTransition#getFrom <em>From</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' reference.
     * @see #getFrom()
     * @generated
     */
	void setFrom(UserTask value);

} // SubTaskTransition
