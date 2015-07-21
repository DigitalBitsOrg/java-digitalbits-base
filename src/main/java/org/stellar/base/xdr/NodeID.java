// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  typedef PublicKey NodeID;

//  ===========================================================================
public class NodeID  {
  private PublicKey NodeID;
  public PublicKey getNodeID() {
    return this.NodeID;
  }
  public void setNodeID(PublicKey value) {
    this.NodeID = value;
  }
  public static void encode(XdrDataOutputStream stream, NodeID  encodedNodeID) throws IOException {
  PublicKey.encode(stream, encodedNodeID.NodeID);
  }
  public static NodeID decode(XdrDataInputStream stream) throws IOException {
    NodeID decodedNodeID = new NodeID();
  decodedNodeID.NodeID = PublicKey.decode(stream);
    return decodedNodeID;
  }
}
