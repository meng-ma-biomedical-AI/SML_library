/*
 * 
 * Copyright or © or Copr. Ecole des Mines d'Alès (2012) 
 * LGI2P research center
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use, 
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and,  more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 * 
 */
package slib.indexer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.openrdf.model.Value;

/**
 *
 * @author Harispe Sébastien <harispe.sebastien@gmail.com>
 */
public class IndexElementBasic implements IndexedElement{
    
    Value associatedValue;
    String preferredDescription;
    Set<String> descriptions;
    
    public IndexElementBasic(Value v){
        associatedValue = v;
        this.descriptions = new HashSet<String>();
    }

    public IndexElementBasic(Value v, String d) {
        this(v);
        this.preferredDescription = d;
        this.descriptions.add(d);
    }
    
    
    @Override
    public void addDescription(String d){
        descriptions.add(d);
    }

    @Override
    public Set<String> getDescriptions() {
        return descriptions;
    }

    @Override
    public String getPreferredDescription() {
        return preferredDescription;
    }

    @Override
    public void setPreferredDescription(String d) {
        this.descriptions.remove(this.preferredDescription);
        this.preferredDescription = d;
        this.descriptions.add(d);
    }

    @Override
    public void addDescriptions(Collection<String> d) {
       descriptions.addAll(d);
    }
    
    @Override
    public void addDescriptions(String[] d) {
       descriptions.addAll(Arrays.asList(d));
    }

    @Override
    public Value getValue() {
        return associatedValue;
    }
    
}