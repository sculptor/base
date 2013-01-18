/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.TypedElement#getType <em>Type</em>}</li>
 *   <li>{@link sculptormetamodel.TypedElement#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link sculptormetamodel.TypedElement#getMapKeyType <em>Map Key Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getTypedElement()
 * @model
 * @generated
 */
public interface TypedElement extends NamedElement {
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getTypedElement_Type()
     * @model
     * @generated
     */
	String getType();

    /**
     * Sets the value of the '{@link sculptormetamodel.TypedElement#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
	void setType(String value);

    /**
     * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Type</em>' attribute.
     * @see #setCollectionType(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getTypedElement_CollectionType()
     * @model
     * @generated
     */
	String getCollectionType();

    /**
     * Sets the value of the '{@link sculptormetamodel.TypedElement#getCollectionType <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collection Type</em>' attribute.
     * @see #getCollectionType()
     * @generated
     */
	void setCollectionType(String value);

    /**
     * Returns the value of the '<em><b>Map Key Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Map Key Type</em>' attribute.
     * @see #setMapKeyType(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getTypedElement_MapKeyType()
     * @model
     * @generated
     */
	String getMapKeyType();

    /**
     * Sets the value of the '{@link sculptormetamodel.TypedElement#getMapKeyType <em>Map Key Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Map Key Type</em>' attribute.
     * @see #getMapKeyType()
     * @generated
     */
	void setMapKeyType(String value);

} // TypedElement