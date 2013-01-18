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
 * A representation of the model object '<em><b>Publish</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Publish#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link sculptormetamodel.Publish#getTopic <em>Topic</em>}</li>
 *   <li>{@link sculptormetamodel.Publish#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getPublish()
 * @model
 * @generated
 */
public interface Publish extends EObject {
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
     * @see sculptormetamodel.SculptormetamodelPackage#getPublish_EventBus()
     * @model
     * @generated
     */
    String getEventBus();

    /**
     * Sets the value of the '{@link sculptormetamodel.Publish#getEventBus <em>Event Bus</em>}' attribute.
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
     * @see sculptormetamodel.SculptormetamodelPackage#getPublish_Topic()
     * @model
     * @generated
     */
    String getTopic();

    /**
     * Sets the value of the '{@link sculptormetamodel.Publish#getTopic <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topic</em>' attribute.
     * @see #getTopic()
     * @generated
     */
    void setTopic(String value);

    /**
     * Returns the value of the '<em><b>Event Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Type</em>' reference.
     * @see #setEventType(Event)
     * @see sculptormetamodel.SculptormetamodelPackage#getPublish_EventType()
     * @model
     * @generated
     */
    Event getEventType();

    /**
     * Sets the value of the '{@link sculptormetamodel.Publish#getEventType <em>Event Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event Type</em>' reference.
     * @see #getEventType()
     * @generated
     */
    void setEventType(Event value);

} // Publish
