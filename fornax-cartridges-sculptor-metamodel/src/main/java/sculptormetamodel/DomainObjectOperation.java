/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Object Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.DomainObjectOperation#getDomainObject <em>Domain Object</em>}</li>
 *   <li>{@link sculptormetamodel.DomainObjectOperation#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getDomainObjectOperation()
 * @model
 * @generated
 */
public interface DomainObjectOperation extends Operation {

    /**
     * Returns the value of the '<em><b>Domain Object</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.DomainObject#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Domain Object</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Domain Object</em>' container reference.
     * @see #setDomainObject(DomainObject)
     * @see sculptormetamodel.SculptormetamodelPackage#getDomainObjectOperation_DomainObject()
     * @see sculptormetamodel.DomainObject#getOperations
     * @model opposite="operations" transient="false"
     * @generated
     */
    DomainObject getDomainObject();

    /**
     * Sets the value of the '{@link sculptormetamodel.DomainObjectOperation#getDomainObject <em>Domain Object</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Domain Object</em>' container reference.
     * @see #getDomainObject()
     * @generated
     */
    void setDomainObject(DomainObject value);

    /**
     * Returns the value of the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Abstract</em>' attribute.
     * @see #setAbstract(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getDomainObjectOperation_Abstract()
     * @model
     * @generated
     */
    boolean isAbstract();

    /**
     * Sets the value of the '{@link sculptormetamodel.DomainObjectOperation#isAbstract <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abstract</em>' attribute.
     * @see #isAbstract()
     * @generated
     */
    void setAbstract(boolean value);
} // DomainObjectOperation
