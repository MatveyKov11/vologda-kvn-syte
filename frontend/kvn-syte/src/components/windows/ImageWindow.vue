<template>
    <div class="back">
        <div :class="fullScreen ? 'window-full' : 'window'">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="fullScreen = !fullScreen">
                    <i :class="fullScreen ? 'zoom-out icon' : 'zoom-in icon'"></i>
                </div>
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"></i>
                </div>
            </div>
            <img :src="props.imageSrc" class="img"/>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const props = defineProps({
    imageSrc: {
        required: true,
        type: String
    }
})

const fullScreen = ref(false)

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 30%;
  width: 40%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
}

.window-full {
  position: fixed;
  z-index: 999;
  top: 0%;
  left: 0%;
  width: 100%;
  height: 100%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
}

.back {
    position: fixed;
    z-index: 998;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.img{
    max-width: 100%;
    max-height: 100%;
}
</style>