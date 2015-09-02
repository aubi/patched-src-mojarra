/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.faces.event;

import javax.faces.context.FacesContext;

/**
 * <p class="changed_added_2_0">This class is provided to allow custom
 * scopes to publish a "post construct" event in the same way that other
 * scopes do to let the application become aware of the beginning of the
 * scope.  The runtime must listen for this event and invoke any
 * <code>PostConstruct</code> annotated methods on any of the beans in
 * this scope as appropriate.  The following code can be used as a
 * template for publishing such an event.</p> 
 * 
 * <pre><code>

Map&lt;String, Object&gt; myScope = getMyScope(); 
ScopeContext scopeContext = new ScopeContext("myScope", myScope);
applicationPublishEvent(PostConstructCustomScopeEvent.class, scopeContext);
</code></pre>
 * 
 * @since 2.0
 */
public class PostConstructCustomScopeEvent extends SystemEvent {


    // ------------------------------------------------------------ Constructors

    private static final long serialVersionUID = 4749939775937702379L;

    /**
     * <p class="changed_added_2_0">An instance of this event indicates
     * that the custom scope enclosed within the argument
     * <code>scopeContext</code> was just created.</p>

     * @param scopeContext A structure that contains the name of the
     * scope and the scope itself exposed as a <code>Map&lt;String,
     * Object&gt;</code>.

     */
    public PostConstructCustomScopeEvent(ScopeContext scopeContext) {

        super(scopeContext);
        
    }

    /**
     * <p class="changed_added_2_3">An instance of this event indicates
     * that the custom scope enclosed within the argument
     * <code>scopeContext</code> was just created.</p>
     * 
     * @param facesContext the Faces context.
     * @param scopeContext A structure that contains the name of the
     * scope and the scope itself exposed as a <code>Map&lt;String,
     * Object&gt;</code>.
     */
    public PostConstructCustomScopeEvent(FacesContext facesContext, ScopeContext scopeContext) {
        super(facesContext, scopeContext);
    }
    
    // ---------------------------------------------------------- Public Methods


    /**
     * <p class="changed_added_2_0">Return the <code>ScopeContext</code>
     * for this event.</p>
     * 
     * @return the scope context.
     */
    public ScopeContext getContext() {

        return (ScopeContext) getSource();

    }

}
