/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link sculptormetamodel.NamedElement#getDoc <em>Doc</em>}</li>
 *   <li>{@link sculptormetamodel.NamedElement#getHint <em>Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getNamedElement_Name()
     * @model
     * @generated
     */
	String getName();

    /**
     * Sets the value of the '{@link sculptormetamodel.NamedElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

    /**
     * Returns the value of the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Doc</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Doc</em>' attribute.
     * @see #setDoc(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getNamedElement_Doc()
     * @model
     * @generated
     */
    String getDoc();

    /**
     * Sets the value of the '{@link sculptormetamodel.NamedElement#getDoc <em>Doc</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Doc</em>' attribute.
     * @see #getDoc()
     * @generated
     */
    void setDoc(String value);

    /**
     * Returns the value of the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hint</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hint</em>' attribute.
     * @see #setHint(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getNamedElement_Hint()
     * @model
     * @generated
     */
    String getHint();

    /**
     * Sets the value of the '{@link sculptormetamodel.NamedElement#getHint <em>Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hint</em>' attribute.
     * @see #getHint()
     * @generated
     */
    void setHint(String value);

} // NamedElement