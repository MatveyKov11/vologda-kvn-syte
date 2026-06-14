<template>
    <div class="ui fluid container">
        <ol class="ui list" v-if="props.listType == 'numb'">
            <li v-for="(el, i) in props.text" :key="i" align="left">
                {{ el }}
                <i class="x icon" @click="$emit('delete', i)"/>
                <i class="arrow up icon" @click="$emit('up', i)"/>
                        <i class="arrow down icon" @click="$emit('down', i)"/>
            </li>
        </ol>
        <ul class="ui list" v-else :style="{listStyleType: props.listType}">
            <li v-for="(el, i) in props.text" :key="i" align="left">
                {{ el }}
                <i class="x icon" @click="$emit('delete', i)"/>
                <i class="arrow up icon" @click="$emit('up', i)"/>
                        <i class="arrow down icon" @click="$emit('down', i)"/>
            </li>
        </ul>
    </div>
    <div class="ui hidden divider"/>
    <div class="ui action fluid input">
        <input type="text" placeholder="Введите элемент..." v-model="inputText" 
            @keypress.enter="$emit('add', inputText); inputText = ''"/>
        <button class="ui blue icon button" @click="$emit('add', inputText); inputText = ''">
            <i class="plus icon"/>
        </button>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
    text: {
        type: Array,
        required: true
    },
    listType: {
        type: String,
        required: true
    }
})
const inputText = ref("")
</script>