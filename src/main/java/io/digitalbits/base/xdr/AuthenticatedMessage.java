// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct AuthenticatedMessage
//  {
//     uint64 sequence;
//     StellarMessage message;
//     HmacSha256Mac mac;
//  };

//  ===========================================================================
public class AuthenticatedMessage  {
  public AuthenticatedMessage () {}
  private Uint64 sequence;
  public Uint64 getSequence() {
    return this.sequence;
  }
  public void setSequence(Uint64 value) {
    this.sequence = value;
  }
  private StellarMessage message;
  public StellarMessage getMessage() {
    return this.message;
  }
  public void setMessage(StellarMessage value) {
    this.message = value;
  }
  private HmacSha256Mac mac;
  public HmacSha256Mac getMac() {
    return this.mac;
  }
  public void setMac(HmacSha256Mac value) {
    this.mac = value;
  }
  public static void encode(XdrDataOutputStream stream, AuthenticatedMessage encodedAuthenticatedMessage) throws IOException{
    Uint64.encode(stream, encodedAuthenticatedMessage.sequence);
    StellarMessage.encode(stream, encodedAuthenticatedMessage.message);
    HmacSha256Mac.encode(stream, encodedAuthenticatedMessage.mac);
  }
  public static AuthenticatedMessage decode(XdrDataInputStream stream) throws IOException {
    AuthenticatedMessage decodedAuthenticatedMessage = new AuthenticatedMessage();
    decodedAuthenticatedMessage.sequence = Uint64.decode(stream);
    decodedAuthenticatedMessage.message = StellarMessage.decode(stream);
    decodedAuthenticatedMessage.mac = HmacSha256Mac.decode(stream);
    return decodedAuthenticatedMessage;
  }
}
