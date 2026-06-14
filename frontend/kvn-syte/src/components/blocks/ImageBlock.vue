<template>
    <div class="ui fluid container" v-if="props.viewType == 'gallery'">
        <img class="main-img" v-if="props.imageSrc.length > 0" :src="props.imageSrc[selectedImage]"/>
        <div class="ui fluid segment">
            <div class="gallery">
                <img v-for="(src, i) in props.imageSrc" :key="i" :src="src" 
                    :class="selectedImage == i ? 'selected-img' : 'unselected-img'"
                    @click="selectedImage = i"/>
            </div>
        </div>
    </div>
    <div class="ui fluid container" v-else>
        <img class="main-img" v-if="props.imageSrc.length > 0" :src="props.imageSrc[selectedImage]"/>
        <button class="circular ui icon button" @click="selectedImage--" v-if="selectedImage > 0">
            <i class="arrow left icon"/>
        </button>
        <button class="circular ui icon button" @click="selectedImage++" v-if="selectedImage < props.imageSrc.length-1">
            <i class="arrow right icon"/>
        </button>
    </div>
    <div class="ui hidden divider"/>
    <div class="ui action fluid input">
        <input type="text" placeholder="Введите ссылку для вставки фото..." v-model="inputText" 
            @keypress.enter="$emit('add', inputText); inputText = ''"/>
        <button class="ui blue icon button" @click="$emit('add', inputText); inputText = ''">
            <i class="edit icon"/>
        </button>
    </div>
    <button class="ui red icon button" @click="$emit('delete')">
        <i class="x icon"/> Удалить последнее изображение
    </button>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
    imageSrc: {
        type: Array,
        required: true
    },
    viewType: {
        type: String,
        required: true
    }
})
const inputText = ref("")
const selectedImage = ref(0)
</script>

<style scoped>
.main-img{
    width: 100%;
    border-color: rgb(0, 0, 0);
    border-width: 5px;
    border-style: solid;
}

.gallery{
    overflow: auto;
    white-space: nowrap;
    padding: 5px;
}
.gallery img{
    height: 150px;
}

.selected-img{
    border-color: rgb(255, 194, 39);
    border-width: 5px;
    border-style: solid;
}

.unselected-img{
    padding: 5px;
}
.unselected-img:hover{
    filter: brightness(60%);
    cursor: pointer;
}
</style>