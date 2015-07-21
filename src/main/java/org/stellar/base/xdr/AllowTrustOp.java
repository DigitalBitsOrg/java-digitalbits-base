// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct AllowTrustOp
//  {
//      AccountID trustor;
//      union switch (AssetType type)
//      {
//      // ASSET_TYPE_NATIVE is not allowed
//      case ASSET_TYPE_CREDIT_ALPHANUM4:
//          opaque assetCode4[4];
//  
//  	case ASSET_TYPE_CREDIT_ALPHANUM12:
//          opaque assetCode12[12];
//  
//          // add other asset types here in the future
//      }
//      asset;
//  
//      bool authorize;
//  };

//  ===========================================================================
public class AllowTrustOp  {
  public AllowTrustOp () {}
  private AccountID trustor;
  public AccountID gettrustor() {
    return this.trustor;
  }
  public void settrustor(AccountID value) {
    this.trustor = value;
  }
  private AllowTrustOpAsset asset;
  public AllowTrustOpAsset getasset() {
    return this.asset;
  }
  public void setasset(AllowTrustOpAsset value) {
    this.asset = value;
  }
  private Boolean authorize;
  public Boolean getauthorize() {
    return this.authorize;
  }
  public void setauthorize(Boolean value) {
    this.authorize = value;
  }
  public static void encode(XdrDataOutputStream stream, AllowTrustOp encodedAllowTrustOp) throws IOException{
    AccountID.encode(stream, encodedAllowTrustOp.trustor);
    AllowTrustOpAsset.encode(stream, encodedAllowTrustOp.asset);
    stream.writeBoolean(encodedAllowTrustOp.authorize);
  }
  public static AllowTrustOp decode(XdrDataInputStream stream) throws IOException {
    AllowTrustOp decodedAllowTrustOp = new AllowTrustOp();
    decodedAllowTrustOp.trustor = AccountID.decode(stream);
    decodedAllowTrustOp.asset = AllowTrustOpAsset.decode(stream);
    decodedAllowTrustOp.authorize = stream.readBoolean();
    return decodedAllowTrustOp;
  }

  public static class AllowTrustOpAsset {
    public AllowTrustOpAsset () {}
    AssetType type;
    public AssetType getDiscriminant() {
      return this.type;
    }
    public void setDiscriminant(AssetType value) {
      this.type = value;
    }
    private byte[] assetCode4;
    public byte[] getassetCode4() {
      return this.assetCode4;
    }
    public void setassetCode4(byte[] value) {
      this.assetCode4 = value;
    }
    private byte[] assetCode12;
    public byte[] getassetCode12() {
      return this.assetCode12;
    }
    public void setassetCode12(byte[] value) {
      this.assetCode12 = value;
    }
    public static void encode(XdrDataOutputStream stream, AllowTrustOpAsset encodedAllowTrustOpAsset) throws IOException {
    stream.writeInt(encodedAllowTrustOpAsset.getDiscriminant().getValue());
    switch (encodedAllowTrustOpAsset.getDiscriminant()) {
    case ASSET_TYPE_CREDIT_ALPHANUM4:
    int assetCode4size = encodedAllowTrustOpAsset.assetCode4.length;
    stream.write(encodedAllowTrustOpAsset.getassetCode4(), 0, assetCode4size);
    break;
    case ASSET_TYPE_CREDIT_ALPHANUM12:
    int assetCode12size = encodedAllowTrustOpAsset.assetCode12.length;
    stream.write(encodedAllowTrustOpAsset.getassetCode12(), 0, assetCode12size);
    break;
    }
    }
    public static AllowTrustOpAsset decode(XdrDataInputStream stream) throws IOException {
      AllowTrustOpAsset decodedAllowTrustOpAsset = new AllowTrustOpAsset();
      switch (decodedAllowTrustOpAsset.getDiscriminant()) {
    case ASSET_TYPE_CREDIT_ALPHANUM4:
    int assetCode4size = 4;
    decodedAllowTrustOpAsset.assetCode4 = new byte[assetCode4size];
    stream.read(decodedAllowTrustOpAsset.assetCode4, 0, assetCode4size);
    break;
    case ASSET_TYPE_CREDIT_ALPHANUM12:
    int assetCode12size = 12;
    decodedAllowTrustOpAsset.assetCode12 = new byte[assetCode12size];
    stream.read(decodedAllowTrustOpAsset.assetCode12, 0, assetCode12size);
    break;
    }
      return decodedAllowTrustOpAsset;
    }

  }
}
