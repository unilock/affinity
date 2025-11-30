package io.wispforest.affinity.mixin.client;

import com.google.common.collect.ImmutableList;
import io.wispforest.affinity.client.render.AbsoluteEnchantmentGlintHandler;
import io.wispforest.affinity.client.render.SkyCaptureBuffer;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayer.class)
public class RenderLayerMixin {
	@Shadow
	@Final
	private static ImmutableList<RenderLayer> BLOCK_LAYERS;

    // TODO: investigate where getArmorGlint and getDirectGlint went

//    @Inject(method = "getArmorGlint", at = @At("HEAD"), cancellable = true)
//    private static void overrideAbsoluteArmorGlint(CallbackInfoReturnable<RenderLayer> cir) {
//        AbsoluteEnchantmentGlintHandler.inject(cir, 0);
//    }

    @Inject(method = "getArmorEntityGlint", at = @At("HEAD"), cancellable = true)
    private static void overrideAbsoluteArmorEntityGlint(CallbackInfoReturnable<RenderLayer> cir) {
        AbsoluteEnchantmentGlintHandler.inject(cir, 0);
    }

    @Inject(method = "getGlintTranslucent", at = @At("HEAD"), cancellable = true)
    private static void overrideAbsoluteTranslucentGlint(CallbackInfoReturnable<RenderLayer> cir) {
        AbsoluteEnchantmentGlintHandler.inject(cir, 1);
    }

    @Inject(method = "getGlint", at = @At("HEAD"), cancellable = true)
    private static void overrideAbsoluteGlint(CallbackInfoReturnable<RenderLayer> cir) {
        AbsoluteEnchantmentGlintHandler.inject(cir, 2);
    }

//    @Inject(method = "getDirectGlint", at = @At("HEAD"), cancellable = true)
//    private static void overrideAbsoluteDirectGlint(CallbackInfoReturnable<RenderLayer> cir) {
//        AbsoluteEnchantmentGlintHandler.inject(cir, 4);
//    }

    @Inject(method = "getEntityGlint", at = @At("HEAD"), cancellable = true)
    private static void overrideAbsoluteEntityGlint(CallbackInfoReturnable<RenderLayer> cir) {
        AbsoluteEnchantmentGlintHandler.inject(cir, 3);
    }

    @Inject(method = "getDirectEntityGlint", at = @At("HEAD"), cancellable = true)
    private static void overrideAbsoluteDirectEntityGlint(CallbackInfoReturnable<RenderLayer> cir) {
        AbsoluteEnchantmentGlintHandler.inject(cir, 4);
    }
	
	static {
		BLOCK_LAYERS = ImmutableList.<RenderLayer>builder().addAll(BLOCK_LAYERS).add(SkyCaptureBuffer.SKY_STENCIL_LAYER).build();
	}

}
