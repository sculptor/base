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
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Operation#getThrows <em>Throws</em>}</li>
 *   <li>{@link sculptormetamodel.Operation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link sculptormetamodel.Operation#getPublish <em>Publish</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends DomainObjectTypedElement {
    /**
     * Returns the value of the '<em><b>Throws</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throws</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Throws</em>' attribute.
     * @see #setThrows(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getOperation_Throws()
     * @model
     * @generated
     */
	String getThrows();

    /**
     * Sets the value of the '{@link sculptormetamodel.Operation#getThrows <em>Throws</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Throws</em>' attribute.
     * @see #getThrows()
     * @generated
     */
	void setThrows(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getOperation_Visibility()
     * @model
     * @generated
     */
	String getVisibility();

    /**
     * Sets the value of the '{@link sculptormetamodel.Operation#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
	void setVisibility(String value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.Parameter}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getOperation_Parameters()
     * @model type="sculptormetamodel.Parameter" containment="true"
     * @generated
     */
	EList getParameters();

    /**
     * Returns the value of the '<em><b>Publish</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Publish</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Publish</em>' reference.
     * @see #setPublish(Publish)
     * @see sculptormetamodel.SculptormetamodelPackage#getOperation_Publish()
     * @model
     * @generated
     */
    Publish getPublish();

    /**
     * Sets the value of the '{@link sculptormetamodel.Operation#getPublish <em>Publish</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Publish</em>' reference.
     * @see #getPublish()
     * @generated
     */
    void setPublish(Publish value);

} // Operation