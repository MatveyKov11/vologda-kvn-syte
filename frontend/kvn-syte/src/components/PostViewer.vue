<template>
    <div class="ui text container">
        <div class="ui fluid input">
            <input type="text" placeholder="Заголовок поста..." v-model="title"/>
        </div>
        <div class="ui segment" v-for="block in blocks" :key="block.id">
            <TextBlock :text="block.data" :colons-number="block.meta" v-if="block.type == 'text'"
                @add="(text) => addItem (block.id, text)" @delete="(j) => removeItem(block.id, j)"
                @up="(j) => upItem(block.id, j)" @down="(j) => downItem(block.id, j)"/>
            <div v-else-if="block.type == 'mark-list'" class="ui fluid container">
                <ul class="ui list">
                    <li v-for="i in block.data.length" :key="i" align="left"> 
                        {{ block.data[i-1] }}
                        <i class="x icon" @click="removeItem(block.id, i-1)"></i>
                        <i class="arrow up icon" @click="upItem(block.id, i-1)"></i>
                        <i class="arrow down icon" @click="downItem(block.id, i-1)"></i>
                    </li>
                </ul>
                <div class="ui action fluid input">
                    <input type="text" placeholder="Введите элемент..." v-model="inputText[block.id]" @keypress.enter="addItem2Block(block.id)"/>
                    <button class="ui blue icon button" @click="addItem2Block(block.id)">
                        <i class="plus icon"></i>
                    </button>
                </div>
            </div>
            <div v-else-if="block.type == 'numb-list'" class="ui fluid container">
                <ol class="ui list">
                    <li v-for="i in block.data.length" :key="i" align="left"> 
                        {{ block.data[i-1] }}
                        <i class="x icon" @click="removeItem(block.id, i-1)"></i>
                        <i class="arrow up icon" @click="upItem(block.id, i-1)"></i>
                        <i class="arrow down icon" @click="downItem(block.id, i-1)"></i>
                    </li>
                </ol>
                <div class="ui action fluid input">
                    <input type="text" placeholder="Введите элемент..." v-model="inputText[block.id]" @keypress.enter="addItem2Block(block.id)"/>
                    <button class="ui blue icon button" @click="addItem2Block(block.id)">
                        <i class="plus icon"></i>
                    </button>
                </div>
            </div>
            <div v-else-if="block.type == 'video'" class="ui fluid container">
                <iframe class="video"
                    :src="block.data[0]" 
                    allow="autoplay; encrypted-media; fullscreen; picture-in-picture; screen-wake-lock;" 
                    frameborder="0" allowfullscreen>
                </iframe>
                <div class="ui action fluid input">
                    <input type="text" placeholder="Введите код для вставки видео..." v-model="inputText[block.id]" @keypress.enter="editSrcVideo(block.id)"/>
                    <button class="ui blue icon button" @click="editSrcVideo(block.id)">
                        <i class="edit icon"></i>
                    </button>
                </div>
            </div>
            <div v-else-if="block.type == 'photo'" class="ui fluid container">
                <img class="video" :src="block.data[0]"/>
                <div class='gallery'>
                    <img v-for="i in block.data.length" :key="i" style="margin-right: 1%; margin-left: 1%;"
                        :width="lenItem(block.data.length)" :src="block.data[i-1]"/>
                </div>
                <div class="ui action fluid input">
                    <input type="text" placeholder="Введите ссылку для вставки фото..." v-model="inputText[block.id]" @keypress.enter="editSrcVideo(block.id)"/>
                    <button class="ui blue icon button" @click="addItem2Block(block.id)">
                        <i class="edit icon"></i>
                    </button>
                </div>
            </div>
            <div v-else>
                {{ block.type }}
                {{ block.type }}
            </div>
            <div class="ui right rail">
                <div class="ui buttons">
                    <div class="ui icon red button" @click="removeBlock(block.id)">
                        <i class="x icon"/>
                    </div>
                    <div class="ui icon primary button" @click="upBlock(block.id)">
                        <i class="arrow up icon"/>
                    </div>
                    <div class="ui icon primary button" @click="downBlock(block.id)">
                        <i class="arrow down icon"/>
                    </div>
                </div>
            </div>
            <div class="ui left rail" v-if="block.type == 'text'">
                <div class="ui segment">
                    <div class="ui form">
                        <div class="inline fields">
                            <label for="colons">Число колонок:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="1" v-model="block.meta">
                                    <label>1</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="2" v-model="block.meta">
                                    <label>2</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="3" v-model="block.meta">
                                    <label>3</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="ui buttons">
        <button class="ui button" @click="addBlock('text')">
            Текст
        </button>
        <button class="ui button" @click="addBlock('mark-list')">
            Маркированный список
        </button>
        <button class="ui button" @click="addBlock('numb-list')">
            Нумерованный список
        </button>
        <button class="ui button" @click="addBlock('photo')">
            Фото
        </button>
        <button class="ui button" @click="addBlock('video')">
            Видео
        </button>
    </div>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"/> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';
import TextBlock from './blocks/TextBlock.vue';

const blocks = ref([
    {
        id: 0,
        type: 'text',
        data: [
            'Раз-раз-раз-раз-раз', 
            'Два-два-два-два-два-два-два', 
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'+ 
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'
        ],
        meta: 1
    },
    {
        id: 1,
        type: 'mark-list',
        data: ['Раз-раз-раз-раз-раз', 'Два-два-два-два-два-два-два', 'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два']
    },
    {
        id: 2,
        type: 'numb-list',
        data: ['Раз-раз-раз-раз-раз', 'Два-два-два-два-два-два-два', 'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два']
    },
    {
        id: 3,
        type: 'video',
        data: ['https://vkvideo.ru/video_ext.php?oid=-127553155&id=456245257&hash=e92d9f33bf048f38&hd=3']
    },
    {
        id: 4,
        type: 'photo',
        data: ['https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t', 
            'https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t',
            'https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t'
        ]
    }
])

const title = ref('Заголовок поста')
const inputText = ['', '', '', '', '', '', '', '', '', '']

function addItem2Block(i){
    blocks.value[i].data.push(inputText[i])
    inputText[i] = ''
}

function addItem(i, text){
    blocks.value[i].data.push(text)
}

function removeItem(i, j){
    for (let k = j; k < blocks.value[i].data.length - 1; k++){
        blocks.value[i].data[k] = blocks.value[i].data[k+1]
    }
    blocks.value[i].data = blocks.value[i].data.slice(0, blocks.value[i].data.length - 1)
}

function upItem(i, j){
    if (j > 0){
        let temp = blocks.value[i].data[j-1].slice()
        blocks.value[i].data[j-1] = blocks.value[i].data[j].slice()
        blocks.value[i].data[j] = temp
    }
}

function downItem(i, j){
    if (j < blocks.value[i].data.length - 1){
        let temp = blocks.value[i].data[j].slice()
        blocks.value[i].data[j] = blocks.value[i].data[j+1].slice()
        blocks.value[i].data[j+1] = temp
    }
}

function editSrcVideo(i){
    let begin = inputText[i].indexOf('"')+1
    console.log(inputText[i])
    console.log(begin)
    console.log(inputText[i].indexOf('"', begin))
    blocks.value[i].data[0] = inputText[i].slice(begin, inputText[i].indexOf('"', begin))
    console.log(blocks.value[i].data[0])
    inputText[i] = ''
}

function lenItem(i){
    return (100 / i) - 2 + '%'
}

function addBlock(t){
    blocks.value.push({
        id: blocks.value.length,
        type: t,
        data: []
    })
}

function removeBlock(i){
    for (let j = i; j < blocks.value.length - 1; j++){
        blocks.value[j] = JSON.parse(JSON.stringify(blocks.value[j+1]))
        blocks.value[j].id = j
    }
    blocks.value = blocks.value.slice(0, blocks.value.length - 1)
}

function upBlock(j){
    if (j > 0){
        let temp = JSON.parse(JSON.stringify(blocks.value[j-1]))
        blocks.value[j-1] = JSON.parse(JSON.stringify(blocks.value[j]))
        blocks.value[j] = temp

        blocks.value[j-1].id = j-1
        blocks.value[j].id = j
    }
}

function downBlock(j){
    if (j < blocks.value.length - 1){
        let temp = JSON.parse(JSON.stringify(blocks.value[j+1]))
        blocks.value[j+1] = JSON.parse(JSON.stringify(blocks.value[j]))
        blocks.value[j] = temp

        blocks.value[j].id = j
        blocks.value[j+1].id = j+1
    }
}

function saveChanges(){
    console.log(JSON.stringify(blocks.value))
}
</script>

<style>
.video{
    width: 100%;
    height: 360px;
}
</style>