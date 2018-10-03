package io.digitalbits.base;

import io.digitalbits.base.xdr.AssetType;

/**
 * Represents Stellar native asset - <a href="https://developer.digitalbits.io/guides/concepts/assets.html" target="_blank">lumens (XLM)</a>
 * @see <a href="https://developer.digitalbits.io/guides/concepts/assets.html" target="_blank">Assets</a>
 */
public class AssetTypeNative extends Asset {

  public AssetTypeNative() {}

  @Override
  public String getType() {
    return "native";
  }

  @Override
  public boolean equals(Object object) {
    return this.getClass().equals(object.getClass());
  }

  @Override
  public io.digitalbits.base.xdr.Asset toXdr() {
    io.digitalbits.base.xdr.Asset xdr = new io.digitalbits.base.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_NATIVE);
    return xdr;
  }
}
