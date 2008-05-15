/*******************************************************************************
 * Copyright (c) 2006, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jpt.core.context.java.JavaAttributeMapping;
import org.eclipse.jpt.core.context.java.JavaPersistentAttribute;
import org.eclipse.jpt.core.context.java.JavaPersistentType;
import org.eclipse.jpt.core.context.java.JavaTypeMapping;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;

/**
 * This interface is to be implemented by a JPA vendor to provide extensions to 
 * the core JPA model.  The core JPA model will provide functionality for JPA
 * spec annotations in java, persistence.xml and (orm.xml) mapping files.
 * The org.eclipse.jpt.core.genericPlatform extension supplies 
 * resource models for those file types.  As another vendor option you 
 * will have to supply those resource models as well or different ones 
 * as necessary.
 * 
 * See the org.eclipse.jpt.core.jpaPlatform extension point
 * 
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 */
public interface JpaPlatform
{
	/**
	 * Get the ID for this platform
	 */
	String getId();

	/**
	 * Set the ID for this platform.  This is an extension
	 * so you can't use a non-default constructor.
	 * 
	 * *************
	 * * IMPORTANT *  For INTERNAL use only!!
	 * *************
	 */
	void setId(String theId);

	
	// **************** Model construction / updating **************************
	
	/**
	 * Construct a JPA file for the specified file, to be added to the specified 
	 * JPA project. (Defer to the factory for actual object creation.)  
	 * Return null if unable to create the JPA file (e.g. the content type is 
	 * unrecognized).
	 */
	JpaFile buildJpaFile(JpaProject jpaProject, IFile file);
	
	/**
	 * Return a factory responsible for creating core (e.g. JpaProject), resource
	 * (e.g. PersistenceResource), and context (e.g. PersistenceUnit) model
	 * objects
	 */
	JpaFactory getJpaFactory();
	
	
	// **************** Java annotation support ********************************
	
	/**
	 * Return an annotation provider responsible for determining what annotations
	 * are supported and constructing java resource model objects
	 */
	JpaAnnotationProvider getAnnotationProvider();
	
	
	// **************** Java type mapping support ********************************
	
	/**
	 * Build a Java type mapping with the given mapping key and parent.  Throws a IllegalArgumentException
	 * if the typeMappingKey is not supported by this platform.
	 * Override {@link #GenericJpaPlatform.addJavaTypeMappingProvidersTo(Collection<JavaTypeMappingProvider>)}
	 * to add new supported type mappings to the platform
	 */
	JavaTypeMapping buildJavaTypeMappingFromMappingKey(String typeMappingKey, JavaPersistentType parent);
	
	/**
	 * Build a Java type mapping with the given mapping annotation and parent.  Throws a IllegalArgumentException
	 * if the mapping annotation is not supported by this platform.
	 * Override {@link #GenericJpaPlatform.addJavaTypeMappingProvidersTo(Collection<JavaTypeMappingProvider>)}
	 * to add new supported type mappings to the platform
	 */
	JavaTypeMapping buildJavaTypeMappingFromAnnotation(String mappingAnnotationName, JavaPersistentType parent);

	// **************** Java attribute mapping support ********************************

	/**
	 * Build a Java attribute mapping with the given mapping key and parent.  Throws a IllegalArgumentException
	 * if the attributeMappingKey is not supported by this platform.
	 * Override {@link #GenericJpaPlatform.addJavaAttributeMappingProvidersTo(Collection<JavaAttributeMappingProvider>)}
	 * to add new supported attribute mappings to the platform
	 */
	JavaAttributeMapping buildJavaAttributeMappingFromMappingKey(String attributeMappingKey, JavaPersistentAttribute parent);
	
	/**
	 * Build a Java attribute mapping with the given mapping annotation and parent.  Throws a IllegalArgumentException
	 * if the mapping annotation is not supported by this platform.
	 * Override {@link #GenericJpaPlatform.addJavaAttributeMappingProvidersTo(Collection<JavaAttributeMappingProvider>)}
	 * to add new supported attribute mappings to the platform
	 */
	JavaAttributeMapping buildJavaAttributeMappingFromAnnotation(String mappingAnnotationName, JavaPersistentAttribute parent);
	
	/**
	 * Build a default Java attribute mapping with the given mapping annotation and parent.  Throws a IllegalArgumentException
	 * if the mapping annotation is not supported by this platform.
	 * Override {@link #GenericJpaPlatform.addDefaultJavaAttributeMappingProvidersTo(Collection<DefaultJavaAttributeMappingProvider>)}
	 * to add new supported attribute mappings to the platform
	 */
	JavaAttributeMapping buildDefaultJavaAttributeMapping(JavaPersistentAttribute parent);
	
	/**
	 * Return the attribute mapping key corresponding to the default atribute mapping
	 * that applies to the Java persistent attribute.  This will be based on the attribute's
	 * type.  See {@link DefaultJavaAttributeMappingProvider.#defaultApplies(JavaPersistentAttribute)}
	 */
	String defaultJavaAttributeMappingKey(JavaPersistentAttribute persistentAttribute);
	
	// *************************************************************************
	
	/**
	 * Adds validation messages to the growing list of messages for a given project
	 */
	void addToMessages(JpaProject project, List<IMessage> messages);
	
}
