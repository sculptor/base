/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sculptormetamodel.Event;
import sculptormetamodel.Publish;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publish</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.PublishImpl#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link sculptormetamodel.impl.PublishImpl#getTopic <em>Topic</em>}</li>
 *   <li>{@link sculptormetamodel.impl.PublishImpl#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PublishImpl extends EObjectImpl implements Publish {
    /**
     * The default value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventBus()
     * @generated
     * @ordered
     */
    protected static final String EVENT_BUS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventBus()
     * @generated
     * @ordered
     */
    protected String eventBus = EVENT_BUS_EDEFAULT;

    /**
     * The default value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected static final String TOPIC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected String topic = TOPIC_EDEFAULT;

    /**
     * The cached value of the '{@link #getEventType() <em>Event Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventType()
     * @generated
     * @ordered
     */
    protected Event eventType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PublishImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.PUBLISH;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEventBus() {
        return eventBus;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventBus(String newEventBus) {
        String oldEventBus = eventBus;
        eventBus = newEventBus;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.PUBLISH__EVENT_BUS, oldEventBus, eventBus));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTopic(String newTopic) {
        String oldTopic = topic;
        topic = newTopic;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.PUBLISH__TOPIC, oldTopic, topic));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Event getEventType() {
        if (eventType != null && eventType.eIsProxy()) {
            InternalEObject oldEventType = (InternalEObject)eventType;
            eventType = (Event)eResolveProxy(oldEventType);
            if (eventType != oldEventType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.PUBLISH__EVENT_TYPE, oldEventType, eventType));
            }
        }
        return eventType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Event basicGetEventType() {
        return eventType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventType(Event newEventType) {
        Event oldEventType = eventType;
        eventType = newEventType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.PUBLISH__EVENT_TYPE, oldEventType, eventType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.PUBLISH__EVENT_BUS:
                return getEventBus();
            case SculptormetamodelPackage.PUBLISH__TOPIC:
                return getTopic();
            case SculptormetamodelPackage.PUBLISH__EVENT_TYPE:
                if (resolve) return getEventType();
                return basicGetEventType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SculptormetamodelPackage.PUBLISH__EVENT_BUS:
                setEventBus((String)newValue);
                return;
            case SculptormetamodelPackage.PUBLISH__TOPIC:
                setTopic((String)newValue);
                return;
            case SculptormetamodelPackage.PUBLISH__EVENT_TYPE:
                setEventType((Event)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
            case SculptormetamodelPackage.PUBLISH__EVENT_BUS:
                setEventBus(EVENT_BUS_EDEFAULT);
                return;
            case SculptormetamodelPackage.PUBLISH__TOPIC:
                setTopic(TOPIC_EDEFAULT);
                return;
            case SculptormetamodelPackage.PUBLISH__EVENT_TYPE:
                setEventType((Event)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SculptormetamodelPackage.PUBLISH__EVENT_BUS:
                return EVENT_BUS_EDEFAULT == null ? eventBus != null : !EVENT_BUS_EDEFAULT.equals(eventBus);
            case SculptormetamodelPackage.PUBLISH__TOPIC:
                return TOPIC_EDEFAULT == null ? topic != null : !TOPIC_EDEFAULT.equals(topic);
            case SculptormetamodelPackage.PUBLISH__EVENT_TYPE:
                return eventType != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (eventBus: ");
        result.append(eventBus);
        result.append(", topic: ");
        result.append(topic);
        result.append(')');
        return result.toString();
    }

} //PublishImpl
