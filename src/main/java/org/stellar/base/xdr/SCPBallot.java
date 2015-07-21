// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct SCPBallot
//  {
//      uint32 counter; // n
//      Value value;    // x
//  };

//  ===========================================================================
public class SCPBallot  {
  public SCPBallot () {}
  private Uint32 counter;
  public Uint32 getcounter() {
    return this.counter;
  }
  public void setcounter(Uint32 value) {
    this.counter = value;
  }
  private Value value;
  public Value getvalue() {
    return this.value;
  }
  public void setvalue(Value value) {
    this.value = value;
  }
  public static void encode(XdrDataOutputStream stream, SCPBallot encodedSCPBallot) throws IOException{
    Uint32.encode(stream, encodedSCPBallot.counter);
    Value.encode(stream, encodedSCPBallot.value);
  }
  public static SCPBallot decode(XdrDataInputStream stream) throws IOException {
    SCPBallot decodedSCPBallot = new SCPBallot();
    decodedSCPBallot.counter = Uint32.decode(stream);
    decodedSCPBallot.value = Value.decode(stream);
    return decodedSCPBallot;
  }
}
