package com.asset.asset_tracking.controller;

import com.asset.asset_tracking.model.Asset;
import com.asset.asset_tracking.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @PostMapping
    public ResponseEntity<Asset> create(@RequestBody Asset asset) {
        Asset created = assetService.createAsset(asset);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Asset>> getAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getById(@PathVariable long id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Asset> update(
            @PathVariable long id,
            @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.updateAsset(id, asset));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        assetService.softDelete(id);
        return ResponseEntity.ok("Asset deleted successfully");
    }
}