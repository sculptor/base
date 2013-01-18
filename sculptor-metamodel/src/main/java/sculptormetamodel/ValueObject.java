/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.ValueObject#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link sculptormetamodel.ValueObject#isPersistent <em>Persistent</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getValueObject()
 * @model
 * @generated
 */
public interface ValueObject extends DomainObject {
    /**
     * Returns the value of the '<em><b>Immutable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Immutable</em>' attribute.
     * @see #setImmutable(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getValueObject_Immutable()
     * @model default="true"
     * @generated
     */
	boolean isImmutable();

    /**
     * Sets the value of the '{@link sculptormetamodel.ValueObject#isImmutable <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Immutable</em>' attribute.
     * @see #isImmutable()
     * @generated
     */
	void setImmutable(boolean value);

    /**
     * Returns the value of the '<em><b>Persistent</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Persistent</em>' attribute.
     * @see #setPersistent(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getValueObject_Persistent()
     * @model default="true"
     * @generated
     */
	boolean isPersistent();

    /**
     * Sets the value of the '{@link sculptormetamodel.ValueObject#isPersistent <em>Persistent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Persistent</em>' attribute.
     * @see #isPersistent()
     * @generated
     */
	void setPersistent(boolean value);

} // ValueObject