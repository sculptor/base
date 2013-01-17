/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.ServiceOperation#getDelegate <em>Delegate</em>}</li>
 *   <li>{@link sculptormetamodel.ServiceOperation#getService <em>Service</em>}</li>
 *   <li>{@link sculptormetamodel.ServiceOperation#getServiceDelegate <em>Service Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getServiceOperation()
 * @model
 * @generated
 */
public interface ServiceOperation extends Operation {
    /**
     * Returns the value of the '<em><b>Delegate</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Delegate</em>' reference.
     * @see #setDelegate(RepositoryOperation)
     * @see sculptormetamodel.SculptormetamodelPackage#getServiceOperation_Delegate()
     * @model
     * @generated
     */
	RepositoryOperation getDelegate();

    /**
     * Sets the value of the '{@link sculptormetamodel.ServiceOperation#getDelegate <em>Delegate</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delegate</em>' reference.
     * @see #getDelegate()
     * @generated
     */
	void setDelegate(RepositoryOperation value);

    /**
     * Returns the value of the '<em><b>Service</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Service#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Service</em>' container reference.
     * @see #setService(Service)
     * @see sculptormetamodel.SculptormetamodelPackage#getServiceOperation_Service()
     * @see sculptormetamodel.Service#getOperations
     * @model opposite="operations" required="true" transient="false"
     * @generated
     */
	Service getService();

    /**
     * Sets the value of the '{@link sculptormetamodel.ServiceOperation#getService <em>Service</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service</em>' container reference.
     * @see #getService()
     * @generated
     */
	void setService(Service value);

    /**
     * Returns the value of the '<em><b>Service Delegate</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Service Delegate</em>' reference.
     * @see #setServiceDelegate(ServiceOperation)
     * @see sculptormetamodel.SculptormetamodelPackage#getServiceOperation_ServiceDelegate()
     * @model
     * @generated
     */
	ServiceOperation getServiceDelegate();

    /**
     * Sets the value of the '{@link sculptormetamodel.ServiceOperation#getServiceDelegate <em>Service Delegate</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Delegate</em>' reference.
     * @see #getServiceDelegate()
     * @generated
     */
	void setServiceDelegate(ServiceOperation value);

} // ServiceOperation