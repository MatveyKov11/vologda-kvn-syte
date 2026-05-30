<template>
    <div class="back">
        <div class="window">
            <img :src="props.imageSrc" class="img"/>
            <div class="ui clearing divider"></div>
            <button class = "ui button" @click="$emit('quit')">Выйти</button>
        </div>
    </div>
</template>

<script setup>

const props = defineProps({
    imageSrc: {
        required: true,
        type: String
    }
})

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
    width: 100%;
}
</style>