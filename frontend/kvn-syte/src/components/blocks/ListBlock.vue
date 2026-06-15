<template>
    <div class="ui fluid container">
        <ol class="ui list" v-if="props.listType == 'numb'">
            <li v-for="(el, i) in props.text" :key="i" align="left">
                {{ el }}
                <i class="x icon" @click="$emit('delete', i)" v-if="props.isEdit"/>
                <i class="arrow up icon" @click="$emit('up', i)" v-if="props.isEdit"/>
                        <i class="arrow down icon" @click="$emit('down', i)" v-if="props.isEdit"/>
            </li>
        </ol>
        <ul class="ui list" v-else :style="{listStyleType: props.listType}">
            <li v-for="(el, i) in props.text" :key="i" align="left">
                {{ el }}
                <i class="x icon" @click="$emit('delete', i)" v-if="props.isEdit"/>
                <i class="arrow up icon" @click="$emit('up', i)" v-if="props.isEdit"/>
                <i class="arrow down icon" @click="$emit('down', i)" v-if="props.isEdit"/>
            </li>
        </ul>
    </div>
    <div class="ui hidden divider" v-if="props.isEdit"/>
    <div class="ui action fluid input" v-if="props.isEdit">
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
    },
    isEdit: {
        type: Boolean,
        required: true
    }
})
const inputText = ref("")
</script>