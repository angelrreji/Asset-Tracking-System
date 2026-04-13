package com.asset.asset_tracking.controller;

import com.asset.asset_tracking.model.Asset;
import com.asset.asset_tracking.service.AssetService;
import com.asset.asset_tracking.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @PostMapping
    public Asset create(@RequestBody Asset asset){
        return assetService.createAsset(asset);
    }

    @GetMapping
    public List<Asset> getAssets(){
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset getById(@PathVariable long id){
        return assetService.getAssetById(id);
    }

    @PatchMapping("/{id}")
    public Asset update(
            @PathVariable long id,
            @RequestBody Asset asset){

        return assetService.updateAsset(id, asset);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        assetService.softDelete(id);
    }
}
