// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct SCPQuorumSet
//  {
//      uint32 threshold;
//      PublicKey validators<>;
//      SCPQuorumSet innerSets<>;
//  };

//  ===========================================================================
public class SCPQuorumSet  {
  public SCPQuorumSet () {}
  private Uint32 threshold;
  public Uint32 getThreshold() {
    return this.threshold;
  }
  public void setThreshold(Uint32 value) {
    this.threshold = value;
  }
  private PublicKey[] validators;
  public PublicKey[] getValidators() {
    return this.validators;
  }
  public void setValidators(PublicKey[] value) {
    this.validators = value;
  }
  private SCPQuorumSet[] innerSets;
  public SCPQuorumSet[] getInnerSets() {
    return this.innerSets;
  }
  public void setInnerSets(SCPQuorumSet[] value) {
    this.innerSets = value;
  }
  public static void encode(XdrDataOutputStream stream, SCPQuorumSet encodedSCPQuorumSet) throws IOException{
    Uint32.encode(stream, encodedSCPQuorumSet.threshold);
    int validatorssize = encodedSCPQuorumSet.getValidators().length;
    stream.writeInt(validatorssize);
    for (int i = 0; i < validatorssize; i++) {
      PublicKey.encode(stream, encodedSCPQuorumSet.validators[i]);
    }
    int innerSetssize = encodedSCPQuorumSet.getInnerSets().length;
    stream.writeInt(innerSetssize);
    for (int i = 0; i < innerSetssize; i++) {
      SCPQuorumSet.encode(stream, encodedSCPQuorumSet.innerSets[i]);
    }
  }
  public static SCPQuorumSet decode(XdrDataInputStream stream) throws IOException {
    SCPQuorumSet decodedSCPQuorumSet = new SCPQuorumSet();
    decodedSCPQuorumSet.threshold = Uint32.decode(stream);
    int validatorssize = stream.readInt();
    decodedSCPQuorumSet.validators = new PublicKey[validatorssize];
    for (int i = 0; i < validatorssize; i++) {
      decodedSCPQuorumSet.validators[i] = PublicKey.decode(stream);
    }
    int innerSetssize = stream.readInt();
    decodedSCPQuorumSet.innerSets = new SCPQuorumSet[innerSetssize];
    for (int i = 0; i < innerSetssize; i++) {
      decodedSCPQuorumSet.innerSets[i] = SCPQuorumSet.decode(stream);
    }
    return decodedSCPQuorumSet;
  }
}
