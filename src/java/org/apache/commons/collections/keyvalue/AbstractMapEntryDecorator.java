/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//collections/src/java/org/apache/commons/collections/keyvalue/AbstractMapEntryDecorator.java,v 1.2 2003/12/06 13:03:15 scolebourne Exp $
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowledgement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.commons.collections.keyvalue;

import java.util.Map;

import org.apache.commons.collections.KeyValue;

/**
 * Provides a base decorator that allows additional functionality to be added
 * to a Map Entry.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 1.2 $ $Date: 2003/12/06 13:03:15 $
 * 
 * @author Stephen Colebourne
 */
public abstract class AbstractMapEntryDecorator implements Map.Entry, KeyValue {
    
    /** The <code>Map.Entry</code> to decorate */
    protected final Map.Entry entry;

    /**
     * Constructor that wraps (not copies).
     *
     * @param entry  the <code>Map.Entry</code> to decorate, must not be null
     * @throws IllegalArgumentException if the collection is null
     */
    public AbstractMapEntryDecorator(Map.Entry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Map Entry must not be null");
        }
        this.entry = entry;
    }

    /**
     * Gets the map being decorated.
     * 
     * @return the decorated map
     */
    protected Map.Entry getMapEntry() {
        return entry;
    }

    //-----------------------------------------------------------------------
    public Object getKey() {
        return entry.getKey();
    }

    public Object getValue() {
        return entry.getValue();
    }

    public Object setValue(Object object) {
        return entry.setValue(object);
    }
   
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return entry.equals(object);
    }

    public int hashCode() {
        return entry.hashCode();
    }

    public String toString() {
        return entry.toString();
    }

}