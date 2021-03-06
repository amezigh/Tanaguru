/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */

package org.tanaguru.rules.rgaa22;

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.ElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.ABBR_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;


/**
 * Implementation of the rule 10.11 of the referential RGAA 2.2.
 * <br/>
 * For more details about the implementation, refer to <a href="http://www.tanaguru.org/en/content/rgaa22-rule-10-11">the rule 10.11 design page.</a>
 * @see <a href="http://rgaa.net/Pertinence-de-la-version-non.html"> 10.11 rule specification </a>
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule10111 extends AbstractPageRuleWithSelectorAndCheckerImplementation {
    
    /** The element selector */
    private static final ElementSelector ELEMENT_SELECTOR = 
            new SimpleElementSelector(ABBR_ELEMENT);
    
    /**
     * Default constructor
     */
    public Rgaa22Rule10111 () {
        super(
                ELEMENT_SELECTOR, 
                new TextEmptinessChecker(
                    new TextAttributeOfElementBuilder(TITLE_ATTR), 
                    TestSolution.NOT_APPLICABLE, 
                    TestSolution.NEED_MORE_INFO, 
                    null, 
                    MANUAL_CHECK_ON_ELEMENTS_MSG, 
                    TEXT_ELEMENT2,
                    TITLE_ATTR
                )
            );
    }

}