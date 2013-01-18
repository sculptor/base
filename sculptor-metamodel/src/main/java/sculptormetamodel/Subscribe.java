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
 * A representation of the model object '<em><b>Subscribe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Subscribe#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link sculptormetamodel.Subscribe#getTopic <em>Topic</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getSubscribe()
 * @model
 * @generated
 */
public interface Subscribe extends EObject {
    /**
     * Returns the value of the '<em><b>Event Bus</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Bus</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Bus</em>' attribute.
     * @see #setEventBus(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getSubscribe_EventBus()
     * @model
     * @generated
     */
    String getEventBus();

    /**
     * Sets the value of the '{@link sculptormetamodel.Subscribe#getEventBus <em>Event Bus</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event Bus</em>' attribute.
     * @see #getEventBus()
     * @generated
     */
    void setEventBus(String value);

    /**
     * Returns the value of the '<em><b>Topic</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topic</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topic</em>' attribute.
     * @see #setTopic(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getSubscribe_Topic()
     * @model
     * @generated
     */
    String getTopic();

    /**
     * Sets the value of the '{@link sculptormetamodel.Subscribe#getTopic <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topic</em>' attribute.
     * @see #getTopic()
     * @generated
     */
    void setTopic(String value);

} // Subscribe
