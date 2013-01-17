/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.ecore.EObject;

import sculptormetamodel.DomainObject;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.ReferenceTarget#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.ReferenceTarget#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceTarget()
 * @model
 * @generated
 */
public interface ReferenceTarget extends EObject {
    /**
     * Returns the value of the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' reference.
     * @see #setReference(Reference)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceTarget_Reference()
     * @model
     * @generated
     */
    Reference getReference();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ReferenceTarget#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(Reference value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(DomainObject)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceTarget_Target()
     * @model
     * @generated
     */
    DomainObject getTarget();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ReferenceTarget#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(DomainObject value);

} // ReferenceTarget
