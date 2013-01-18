/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consumer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Consumer#getModule <em>Module</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getRepositoryDependencies <em>Repository Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getChannel <em>Channel</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getMessageRoot <em>Message Root</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getOtherDependencies <em>Other Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.Consumer#getSubscribe <em>Subscribe</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getConsumer()
 * @model
 * @generated
 */
public interface Consumer extends NamedElement {
    /**
     * Returns the value of the '<em><b>Module</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Module#getConsumers <em>Consumers</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(Module)
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_Module()
     * @see sculptormetamodel.Module#getConsumers
     * @model opposite="consumers" transient="false"
     * @generated
     */
    Module getModule();

    /**
     * Sets the value of the '{@link sculptormetamodel.Consumer#getModule <em>Module</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
    void setModule(Module value);

    /**
     * Returns the value of the '<em><b>Repository Dependencies</b></em>' reference list.
     * The list contents are of type {@link sculptormetamodel.Repository}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repository Dependencies</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Repository Dependencies</em>' reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_RepositoryDependencies()
     * @model type="sculptormetamodel.Repository"
     * @generated
     */
    EList getRepositoryDependencies();

    /**
     * Returns the value of the '<em><b>Service Dependencies</b></em>' reference list.
     * The list contents are of type {@link sculptormetamodel.Service}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Dependencies</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Dependencies</em>' reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_ServiceDependencies()
     * @model type="sculptormetamodel.Service"
     * @generated
     */
    EList getServiceDependencies();

    /**
     * Returns the value of the '<em><b>Channel</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Channel</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Channel</em>' attribute.
     * @see #setChannel(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_Channel()
     * @model
     * @generated
     */
    String getChannel();

    /**
     * Sets the value of the '{@link sculptormetamodel.Consumer#getChannel <em>Channel</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Channel</em>' attribute.
     * @see #getChannel()
     * @generated
     */
    void setChannel(String value);

    /**
     * Returns the value of the '<em><b>Message Root</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Message Root</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Message Root</em>' reference.
     * @see #setMessageRoot(DomainObject)
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_MessageRoot()
     * @model
     * @generated
     */
    DomainObject getMessageRoot();

    /**
     * Sets the value of the '{@link sculptormetamodel.Consumer#getMessageRoot <em>Message Root</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Message Root</em>' reference.
     * @see #getMessageRoot()
     * @generated
     */
    void setMessageRoot(DomainObject value);

    /**
     * Returns the value of the '<em><b>Other Dependencies</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Other Dependencies</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Other Dependencies</em>' attribute list.
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_OtherDependencies()
     * @model
     * @generated
     */
    EList getOtherDependencies();

    /**
     * Returns the value of the '<em><b>Subscribe</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subscribe</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subscribe</em>' reference.
     * @see #setSubscribe(Subscribe)
     * @see sculptormetamodel.SculptormetamodelPackage#getConsumer_Subscribe()
     * @model
     * @generated
     */
    Subscribe getSubscribe();

    /**
     * Sets the value of the '{@link sculptormetamodel.Consumer#getSubscribe <em>Subscribe</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subscribe</em>' reference.
     * @see #getSubscribe()
     * @generated
     */
    void setSubscribe(Subscribe value);

} // Consumer