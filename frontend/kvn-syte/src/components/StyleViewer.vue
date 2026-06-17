<template>
    <div class="ui container">
        <div class="ui input">
            <input type="text" name="name" v-model="styleName" placeholder="Название стиля...">
        </div>
        <div class="ui input">
            <input type="text" name="font" v-model="fontName" placeholder="Название шрифта...">
        </div>
        <div class="ui input">
            <input type="number" name="size" v-model="fontSize" placeholder="14">
        </div>
        <div class="ui segment" v-for="(color, i) in colors" :key="i">
            {{ color.r }} {{ color.b }} {{ color.g }}
        </div>
        <button class="ui primary button" @click="addColor">
            <i class="plus icon"/> Добавить цвет
        </button>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const styleName = ref('')
const fontName = ref('Times New Roman')
const fontSize = ref(14)
const colors = ref([
    {
        r: 122,
        g: 111,
        b: 111
    }
])

function addColor(){
    colors.value.push({r:0, g: 0, b: 0})
}
</script>