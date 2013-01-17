/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see sculptormetamodel.SculptormetamodelPackage
 * @generated
 */
public interface SculptormetamodelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	SculptormetamodelFactory eINSTANCE = sculptormetamodel.impl.SculptormetamodelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Application</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Application</em>'.
     * @generated
     */
	Application createApplication();

    /**
     * Returns a new object of class '<em>Service</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Service</em>'.
     * @generated
     */
	Service createService();

    /**
     * Returns a new object of class '<em>Repository</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Repository</em>'.
     * @generated
     */
	Repository createRepository();

    /**
     * Returns a new object of class '<em>Reference</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Reference</em>'.
     * @generated
     */
	Reference createReference();

    /**
     * Returns a new object of class '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Typed Element</em>'.
     * @generated
     */
	TypedElement createTypedElement();

    /**
     * Returns a new object of class '<em>Domain Object Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Domain Object Typed Element</em>'.
     * @generated
     */
	DomainObjectTypedElement createDomainObjectTypedElement();

    /**
     * Returns a new object of class '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute</em>'.
     * @generated
     */
	Attribute createAttribute();

    /**
     * Returns a new object of class '<em>Operation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation</em>'.
     * @generated
     */
	Operation createOperation();

    /**
     * Returns a new object of class '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
	Parameter createParameter();

    /**
     * Returns a new object of class '<em>Repository Operation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Repository Operation</em>'.
     * @generated
     */
	RepositoryOperation createRepositoryOperation();

    /**
     * Returns a new object of class '<em>Service Operation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Service Operation</em>'.
     * @generated
     */
	ServiceOperation createServiceOperation();

    /**
     * Returns a new object of class '<em>Value Object</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Object</em>'.
     * @generated
     */
	ValueObject createValueObject();

    /**
     * Returns a new object of class '<em>Entity</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Entity</em>'.
     * @generated
     */
	Entity createEntity();

    /**
     * Returns a new object of class '<em>Module</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Module</em>'.
     * @generated
     */
	Module createModule();

    /**
     * Returns a new object of class '<em>Basic Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Basic Type</em>'.
     * @generated
     */
	BasicType createBasicType();

    /**
     * Returns a new object of class '<em>Consumer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Consumer</em>'.
     * @generated
     */
    Consumer createConsumer();

    /**
     * Returns a new object of class '<em>Enum</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum</em>'.
     * @generated
     */
	Enum createEnum();

				/**
     * Returns a new object of class '<em>Enum Value</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Value</em>'.
     * @generated
     */
	EnumValue createEnumValue();

				/**
     * Returns a new object of class '<em>Enum Constructor Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Constructor Parameter</em>'.
     * @generated
     */
	EnumConstructorParameter createEnumConstructorParameter();

				/**
     * Returns a new object of class '<em>Inheritance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Inheritance</em>'.
     * @generated
     */
    Inheritance createInheritance();

                /**
     * Returns a new object of class '<em>Data Transfer Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Transfer Object</em>'.
     * @generated
     */
    DataTransferObject createDataTransferObject();

                /**
     * Returns a new object of class '<em>Command Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Command Event</em>'.
     * @generated
     */
    CommandEvent createCommandEvent();

                /**
     * Returns a new object of class '<em>Domain Event</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Domain Event</em>'.
     * @generated
     */
    DomainEvent createDomainEvent();

                /**
     * Returns a new object of class '<em>Subscribe</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Subscribe</em>'.
     * @generated
     */
    Subscribe createSubscribe();

                /**
     * Returns a new object of class '<em>Publish</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Publish</em>'.
     * @generated
     */
    Publish createPublish();

                /**
     * Returns a new object of class '<em>Trait</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trait</em>'.
     * @generated
     */
    Trait createTrait();

                /**
     * Returns a new object of class '<em>Domain Object Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Domain Object Operation</em>'.
     * @generated
     */
    DomainObjectOperation createDomainObjectOperation();

                /**
     * Returns a new object of class '<em>Resource</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource</em>'.
     * @generated
     */
    Resource createResource();

                /**
     * Returns a new object of class '<em>Resource Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resource Operation</em>'.
     * @generated
     */
    ResourceOperation createResourceOperation();

                /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	SculptormetamodelPackage getSculptormetamodelPackage();

} //SculptormetamodelFactory
