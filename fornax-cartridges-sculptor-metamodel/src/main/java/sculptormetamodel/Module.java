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
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Module#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getApplication <em>Application</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getDomainObjects <em>Domain Objects</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getConsumers <em>Consumers</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getServices <em>Services</em>}</li>
 *   <li>{@link sculptormetamodel.Module#isExternal <em>External</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getPersistenceUnit <em>Persistence Unit</em>}</li>
 *   <li>{@link sculptormetamodel.Module#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends NamedElement {
    /**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_BasePackage()
     * @model
     * @generated
     */
	String getBasePackage();

    /**
     * Sets the value of the '{@link sculptormetamodel.Module#getBasePackage <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
	void setBasePackage(String value);

    /**
     * Returns the value of the '<em><b>Application</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Application#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Application</em>' container reference.
     * @see #setApplication(Application)
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_Application()
     * @see sculptormetamodel.Application#getModules
     * @model opposite="modules" transient="false"
     * @generated
     */
	Application getApplication();

    /**
     * Sets the value of the '{@link sculptormetamodel.Module#getApplication <em>Application</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Application</em>' container reference.
     * @see #getApplication()
     * @generated
     */
	void setApplication(Application value);

    /**
     * Returns the value of the '<em><b>Services</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.Service}.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Service#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Services</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_Services()
     * @see sculptormetamodel.Service#getModule
     * @model type="sculptormetamodel.Service" opposite="module" containment="true"
     * @generated
     */
	EList getServices();

    /**
     * Returns the value of the '<em><b>External</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>External</em>' attribute.
     * @see #setExternal(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_External()
     * @model
     * @generated
     */
	boolean isExternal();

				/**
     * Sets the value of the '{@link sculptormetamodel.Module#isExternal <em>External</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>External</em>' attribute.
     * @see #isExternal()
     * @generated
     */
	void setExternal(boolean value);

				/**
     * Returns the value of the '<em><b>Persistence Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Persistence Unit</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Persistence Unit</em>' attribute.
     * @see #setPersistenceUnit(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_PersistenceUnit()
     * @model
     * @generated
     */
    String getPersistenceUnit();

                /**
     * Sets the value of the '{@link sculptormetamodel.Module#getPersistenceUnit <em>Persistence Unit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Persistence Unit</em>' attribute.
     * @see #getPersistenceUnit()
     * @generated
     */
    void setPersistenceUnit(String value);

                /**
     * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.Resource}.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Resource#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resources</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_Resources()
     * @see sculptormetamodel.Resource#getModule
     * @model type="sculptormetamodel.Resource" opposite="module" containment="true"
     * @generated
     */
    EList getResources();

                /**
     * Returns the value of the '<em><b>Domain Objects</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.DomainObject}.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.DomainObject#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Domain Objects</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_DomainObjects()
     * @see sculptormetamodel.DomainObject#getModule
     * @model type="sculptormetamodel.DomainObject" opposite="module" containment="true"
     * @generated
     */
	EList getDomainObjects();

    /**
     * Returns the value of the '<em><b>Consumers</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.Consumer}.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Consumer#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consumers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consumers</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getModule_Consumers()
     * @see sculptormetamodel.Consumer#getModule
     * @model type="sculptormetamodel.Consumer" opposite="module" containment="true"
     * @generated
     */
    EList getConsumers();

} // Module