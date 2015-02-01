/*
 * Copyright 2015 Otmar.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mifmif.common.regex;

import dk.brics.automaton.Transition;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Otmar
 */
public class ExhaustiveGenerationTest {
    class ConvenienceRegexTesting
        {
            public String regex;
            public Set<String> expectedExamples;
            
            ConvenienceRegexTesting(String regex, List<String> expected){
                this.regex = regex;
                this.expectedExamples = new HashSet<String>(expected);
                this.run();
            }
            
            void run(){
                Generex g = new Generex(this.regex);
                this.actualExamples = g.getAllMatchedStringsViaStatePermutations();
                
                final Set<String> actualSet = actualExamples;
                actuallyAbsent = expectedExamples.stream().filter(expec -> !actualSet.contains(expec)).collect(Collectors.toSet());
            }
            
                
            public Set<String> actualExamples;
            
            public Set<String> actuallyAbsent;
           
        }
        
        @Test
        public void testJavaMopCasesForJavaUtil(){
            ConvenienceRegexTesting test =  new ConvenienceRegexTesting("cu*m+u", Arrays.asList("cmu", "cumu", "cmmu", "cummu"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test =  new ConvenienceRegexTesting("b|(ca)", Arrays.asList("b", "ca"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test =  new ConvenienceRegexTesting("(ab)|(acd)", Arrays.asList("ab", "acd"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test =  new ConvenienceRegexTesting("ab(c|(de))", Arrays.asList("abc", "abde"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test =  new ConvenienceRegexTesting("(elm*)*", Arrays.asList("el", "elm"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("ca+", Arrays.asList("ca", "caa"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("u", Arrays.asList("u"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("(n+(r| ))*", Arrays.asList("nr", "nnr", "nn", "n"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("((n|p)+(r| ))*", Arrays.asList("n", "nn","nr", "nnr", "p","pp", "pr","ppr","np","npr", "pn","pnr"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("ca*", Arrays.asList("c", "ca"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("ca*((n|p)+s*(r|a+| ))*", Arrays.asList("cnnr","cnnaa","cnna","cnn","cnpr","cnpaa","cnpa","cnp","cnsr","cnsaa","cnsa","cns","cnr","cnaa","cna","cn","cpnr","cpnaa","cpna","cpn","cppr","cppaa","cppa","cpp","cpsr","cpsaa","cpsa","cps","cpr","cpaa","cpa","cp","cannr","cannaa","canna","cann","canpr","canpaa","canpa","canp","cansr","cansaa","cansa","cans","canr","canaa","cana","can","capnr","capnaa","capna","capn","cappr","cappaa","cappa","capp","capsr","capsaa","capsa","caps","capr","capaa","capa","cap"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("ga+", Arrays.asList("ga","gaa"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("g(m|c)*iu*(m|c)+u", Arrays.asList("gimu","gicu","gimmu","giccu","gimcu","gicmu","giumu","giucu","giummu","giuccu","giumcu","giucmu","gcimu","gcicu","gcimmu","gciccu","gcimcu","gcicmu","gciumu","gciucu","gciummu","gciuccu","gciumcu","gciucmu","gmimu","gmicu","gmimmu","gmiccu","gmimcu","gmicmu","gmiumu","gmiucu","gmiummu","gmiuccu","gmiumcu","gmiucmu"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("(elm*)*", Arrays.asList("el","elm"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
            
            test = new ConvenienceRegexTesting("c(x|y)*(g|h)(x|y|z)*iu*(x|y|z)+u", Arrays.asList("cgixu","chixu","cgiyu","chiyu","cgizu","chizu","cxgixu","cxhixu","cxgiyu","cxhiyu","cxgizu","cxhizu","cygixu","cyhixu","cygiyu","cyhiyu","cygizu","cyhizu","cgixu","chixu","cgiyu","chiyu","cgizu","chizu","cxgixu","cxhixu","cxgiyu","cxhiyu","cxgizu","cxhizu","cygixu","cyhixu","cygiyu","cyhiyu","cygizu","cyhizu","cgxixu","chxixu","cgxiyu","chxiyu","cgxizu","chxizu","cxgxixu","cxhxixu","cxgxiyu","cxhxiyu","cxgxizu","cxhxizu","cygxixu","cyhxixu","cygxiyu","cyhxiyu","cygxizu","cyhxizu","cgyixu","chyixu","cgyiyu","chyiyu","cgyizu","chyizu","cxgyixu","cxhyixu","cxgyiyu","cxhyiyu","cxgyizu","cxhyizu","cygyixu","cyhyixu","cygyiyu","cyhyiyu","cygyizu","cyhyizu","cgzixu","chzixu","cgziyu","chziyu","cgzizu","chzizu","cxgzixu","cxhzixu","cxgziyu","cxhziyu","cxgzizu","cxhzizu","cygzixu","cyhzixu","cygziyu","cyhziyu","cygzizu","cyhzizu"));
            Assert.assertTrue(test.actuallyAbsent.isEmpty());
            Assert.assertTrue(test.actualExamples.containsAll(test.expectedExamples));
        }
}
