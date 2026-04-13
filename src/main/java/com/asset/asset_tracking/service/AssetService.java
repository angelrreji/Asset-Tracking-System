package com.asset.asset_tracking.service;

import com.asset.asset_tracking.model.Asset;
import com.asset.asset_tracking.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository repo;

    public Asset createAsset(Asset asset) {
        asset.setDeleted(false);
        return repo.save(asset);
    }

    public List<Asset> getAllAssets() {
        return repo.findByDeletedFalse();
    }

    public Asset getAssetById(Long id) {
        return repo.findById(id)
                .orElseThrow();
    }

    public Asset updateAsset(long id, Asset updated) {
        Asset asset = repo.findById(id).orElseThrow();

        if (updated.getAssetName() != null) {
            asset.setAssetName(updated.getAssetName());
        }
        if (updated.getAssetModel() != null) {
            asset.setAssetModel(updated.getAssetModel());
        }
        return repo.save(asset);
    }

    public void softDelete(long id) {
        Asset asset = repo.findById(id).orElseThrow();
        asset.setDeleted(true);
        repo.save(asset);
    }

}
